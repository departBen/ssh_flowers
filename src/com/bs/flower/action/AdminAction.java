package com.bs.flower.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.bs.flower.dao.UserDao;
import com.bs.flower.entity.Admin;
import com.bs.flower.entity.Category;
import com.bs.flower.entity.Goods;
import com.bs.flower.entity.Orders;
import com.bs.flower.entity.Users;
import com.bs.flower.service.CategoryService;
import com.bs.flower.service.FlowerService;
import com.bs.flower.service.UserService;
import com.bs.flower.utils.Pager;
import com.bs.flower.utils.UploadFile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	// spring注入
	private CategoryService categoryService;
	private FlowerService flowerService;
	private UserService userService;

	// struts管理
	private Category category;
	private List<Category> categories;
	private String msg;
	private Goods flower;
	private File upload;
	private String uploadFileName;
	private Pager page;
	private int currentPage = 1;
	private List<Goods> flowers;
	private String pictureUrl;
	private int id;
	private List<Orders> orders;
	private List<Users> users;
	private Users user;
	private String userName;
	private String realName;
	private Admin admin;
	private String err;
	
	
	/**
	 * 管理员登陆
	 * @return
	 */
	public String adminLogin(){
		
        Map session = (Map) ActionContext.getContext().getSession();
        Admin a = userService.checkAdmin(admin);
        if (a != null){
            session.put("admin",a);
            return "login success";
        }else {
            err = "用户名或密码错误";
            return "login";
        }
    }
	
	/**
	 * 登出
	 * @return
	 */
	public String adminLogout(){
		Map session = ActionContext.getContext().getSession();
		session.remove("admin");
		return "logout";
	}
	

	/**
	 * 增加分类
	 * 
	 * @return
	 */
	public String addCategory() {
		Category _category = new Category();
		_category.setCategoryName(category.getCategoryName());
		categoryService.saveCategory(_category);
		msg = "添加成功!";
		return "addCateSucess";
	}

	/**
	 * 增加花品页面
	 * 
	 * @return
	 */
	public String addFlowersView() {
		categories = categoryService.getAllCategories();
		return "addFlowersView";
	}

	public String editFlowerView() {
		Goods editFlower = flowerService.getFlowerById(flower.getId());
		flower = editFlower;
		return addFlowersView();
	}

	/**
	 * 增加或修改花品
	 * 
	 * @return
	 */
	public String addOrUpdateFlower() {
		if (this.getUpload() != null) {
			String path = ServletActionContext.getServletContext().getRealPath("/pic");
			List<Goods> fList = flowerService.getNewFlowers();
			int currentPicId = 0;
			if (fList.size() > 0) {
				Goods flower1 = (Goods) fList.get(0);// 获取最新一个鲜花
				currentPicId = flower1.getId() + 1;// 用作新鲜花上传图片的名字
				path = path + "/" + currentPicId + this.getUploadFileName();
				UploadFile.upload(this.getUpload(), path);
			} else {
				currentPicId = 1;
				path = path + "/" + currentPicId + this.getUploadFileName();
				UploadFile.upload(this.getUpload(), path);
			}
			flower.setImgUrl(currentPicId + this.getUploadFileName());
		}
		
		Goods newFlower = new Goods();
		if (id > 0) {
			newFlower.setId(id);
		}
		if (flower.getImgUrl() == null) {
			newFlower.setImgUrl(pictureUrl);
		} else {
			newFlower.setImgUrl(flower.getImgUrl());
		}

		newFlower.setCategory(flower.getCategory());
		newFlower.setGoodsName(flower.getGoodsName());
		newFlower.setPrice(flower.getPrice());
		newFlower.setDescription(flower.getDescription());
		flowerService.saveOrUpdate(newFlower);

		flower = new Goods();
		return browseFlowersBypage();
	}

	/**
	 * 修改花品页面
	 * 
	 * @return
	 */
	public String browseFlowersBypage() {
		int totalSize = flowerService.getTotal();
		page = new Pager(currentPage, totalSize);
		page.setPageSize(8);
		flowers = flowerService.getFlowerpagging(currentPage, page.getPageSize());
		return "pageFlowers";
	}
	
	/**
	 * 删除花品
	 * @return
	 */
	public String deleteFolwers(){
		flowerService.deleteFlower(flower.getId());
		return browseFlowersBypage();
	}
	
	/**
	 * 订单信息
	 * @return
	 */
	public String ordersPagging(){
		int totalSize = flowerService.getOrderTotal();
		page = new Pager(currentPage, totalSize);
		page.setPageSize(8);
		orders = flowerService.getOrdersPagging(currentPage, page.getPageSize());
		return "ordersList";
	}
	
	/**
	 * 用户管理用户列表
	 * @return
	 */
	public String userManagerPagging(){
		int totalSize = userService.getOrderTotal();
		page = new Pager(currentPage, totalSize);
		page.setPageSize(8);
		users = userService.getUsersPagging(currentPage, page.getPageSize());
		return "userManage";
	}
	
	/**
	 * 用户修改页面
	 * @return
	 */
	public String userEditView(){
		Users u = userService.getUserById(user.getId());
		user = u;
		return "userEdit";
	}
	
	/**
	 * 用户修改
	 * @return
	 */
	public String userEdit(){
		Users newUser = new Users();
		newUser.setId(id);
		newUser.setUserName(userName);
		newUser.setRealName(realName);
		newUser.setPassword(user.getPassword());
		newUser.setPwdQuestion(user.getPwdQuestion());
		newUser.setPwdQuestionAnswer(user.getPwdQuestionAnswer());
		newUser.setPhoneNo(user.getPhoneNo());
		newUser.setAddress(user.getAddress());
		newUser.setEmail(user.getEmail());
		
		userService.save(newUser);
		
		return userManagerPagging();
	}
	
	
//	----------------------------set get-----------------------------------

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public FlowerService getFlowerService() {
		return flowerService;
	}

	public void setFlowerService(FlowerService flowerService) {
		this.flowerService = flowerService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Goods getFlower() {
		return flower;
	}

	public void setFlower(Goods flower) {
		this.flower = flower;
	}

	public Pager getPage() {
		return page;
	}

	public void setPage(Pager page) {
		this.page = page;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Goods> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Goods> flowers) {
		this.flowers = flowers;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public String getErr() {
		return err;
	}


	public void setErr(String err) {
		this.err = err;
	}

	
	
}
