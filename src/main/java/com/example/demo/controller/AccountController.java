package com.example.demo.controller;

import java.security.MessageDigest;
import com.example.demo.domain.Account;
import com.example.demo.domain.Admin;
import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.service.AccountService;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/account/")
@SessionAttributes({"account", "myList", "authenticated"})
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CatalogService catalogService;

    private static final List<String> LANGUAGE_LIST;
    private static final List<String> CATEGORY_LIST;

    static {
        List<String> langList = new ArrayList<String>();
        langList.add("ENGLISH");
        langList.add("CHINESE");
        LANGUAGE_LIST = Collections.unmodifiableList(langList);

        List<String> catList = new ArrayList<String>();
        catList.add("FISH");
        catList.add("DOGS");
        catList.add("REPTILES");
        catList.add("CATS");
        catList.add("BIRDS");

        CATEGORY_LIST = Collections.unmodifiableList(catList);
    }

//    //登录表单
//    @GetMapping("signonForm")
//    public String signonForm() {
//        return "account/signon";
//    }
//
//    //登录账户
//    @PostMapping("signon")
//    public String signon(String username, String password, Model model) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//
//        //判断密码并进行加密
//        if(!password.equals("")){
//            password = toMD5(password);
//        }
//
//        Account account = accountService.getAccount(username, password);
//
//        if (account == null) {
//            String msg = "Invalid username or password.  Signon failed.";
//            model.addAttribute("msg", msg);
//            return "account/signon";
//        } else {
////            account.setPassword(toMD5(account.getPassword()));
//            System.out.println("username: " + account.getUsername() + "password:" + account.getPassword());
////            account.setPassword(null);
//            List<Product> myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
//            boolean authenticated = true;
//            model.addAttribute("account", account);
//            model.addAttribute("myList", myList);
//            model.addAttribute("authenticated", authenticated);
//            return "catalog/main";
//        }
//    }
//
//    //登出
//    @GetMapping("signoff")
//    public String signoff(Model model) {
//        Account loginAccount = new Account();
//        List<Product> myList = null;
//        boolean authenticated = false;
//        model.addAttribute("account", loginAccount);
//        model.addAttribute("myList", myList);
//        model.addAttribute("authenticated", authenticated);
//        return "catalog/main";
//    }
//
//    @GetMapping("editAccountForm")
//    public String editAccountForm(@SessionAttribute("account") Account account, Model model) {
//        model.addAttribute("account", account);
//        model.addAttribute("LANGUAGE_LIST", LANGUAGE_LIST);
//        model.addAttribute("CATEGORY_LIST", CATEGORY_LIST);
//        return "account/edit_account";
//    }
//
//    //修改用户信息
//    @PostMapping("editAccount")
//    public String editAccount(Account account, String repeatedPassword, Model model) {
//        if (account.getPassword() == null || account.getPassword().length() == 0 || repeatedPassword == null || repeatedPassword.length() == 0) {
//            String msg = "密码不能为空";
//            model.addAttribute("msg", msg);
//            return "account/edit_account";
//        } else if (!account.getPassword().equals(repeatedPassword)) {
//            String msg = "两次密码不一致";
//            model.addAttribute("msg", msg);
//            return "account/edit_account";
//        } else {
//            accountService.updateAccount(account);
//            account = accountService.getAccount(account.getUsername());
//            List<Product> myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
//            boolean authenticated = true;
//            model.addAttribute("account", account);
//            model.addAttribute("myList", myList);
//            model.addAttribute("authenticated", authenticated);
//            return "redirect:/catalog/index";
//        }
//    }
//
//    //创建一个新的用户表单
//    @GetMapping("newAccountForm")
//    public String newAccountForm(Model model){
//        model.addAttribute("newAccount",new Account());
//        model.addAttribute("LANGUAGE_LIST", LANGUAGE_LIST);
//        model.addAttribute("CATEGORY_LIST", CATEGORY_LIST);
//        return "account/new_account";
//    }
//
//    // 邮箱验证的新账户 跳转
//    @RequestMapping("newAccountFormByEAC")
//    public String newAccountForm_eac(Model model) {
//        model.addAttribute("newAccount",new Account());
//        model.addAttribute("LANGUAGE_LIST", LANGUAGE_LIST);
//        model.addAttribute("CATEGORY_LIST", CATEGORY_LIST);
//        return "account/new_eac_account";
//    }
//
//    //创建一个新的用户
//    @PostMapping("newAccount")
//    public  String newAccount(Account account, Model model) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        //对密码进行加密
//        String temp = toMD5(account.getPassword());
//        account.setPassword(temp);
//        accountService.insertAccount(account);
//        return "catalog/main";
//    }
//
//    //从邮箱创建一个新的用户
//    @PostMapping("newEAccount")
//    public String newEAccount(Account account, Model model) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        //对密码进行加密
//        String temp = toMD5(account.getPassword());
//        account.setPassword(temp);
//        accountService.insertAccount(account);
//        return "catalog/main";
//    }

//    //加密函数，用于将接收到的密码加密并返回值
//    public static String toMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        MessageDigest md=MessageDigest.getInstance("MD5");
//        byte[] strByteArray=str.getBytes("utf-8");
//        byte[] mdByteArray=md.digest(strByteArray);
//        StringBuffer hexValue=new StringBuffer();
//        for(int i=0;i<mdByteArray.length;i++){
//            int val=((int)mdByteArray[i])&0xff;
//            if(val<16){
//                hexValue.append("0");
//            }
//            hexValue.append(Integer.toHexString(val));
//        }
//        return hexValue.toString();
//
//    }


    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }


    //获取所有的用户
    @GetMapping("/searchAllAccount")
    @ResponseBody
    public List<Account>  getAccount() {
        List<Account> account = accountService.getAccountList();
        System.out.println(account);
        return account;
    }


    //由用户名来获取用户
    @GetMapping("/searchAccount/{id}")
    @ResponseBody
    public Account getAccountById(@PathVariable String id) {
        Account account = accountService.getAccount(id);
        System.out.println(account);
        return account;
    }



    //修改用户信息
    @PutMapping("/updateAccount/{id}")
    @ResponseBody
    public void Update(@PathVariable("id")String id,
                       @RequestParam(value = "password", required = false)String password,
                       @RequestParam(value = "email", required = false)String email,
                       @RequestParam(value = "firstname", required = false)String firstName,
                       @RequestParam(value = "lastname", required = false)String lastName,
                       @RequestParam(value = "status", required = false)String status,
                       @RequestParam(value = "addr1", required = false)String address1,
                       @RequestParam(value = "addr2", required = false)String address2,
                       @RequestParam(value = "city",required = false)String city,
                       @RequestParam(value = "state",required = false)String state,
                       @RequestParam(value = "zip",required = false)String zip,
                       @RequestParam(value = "country",required = false)String country,
                       @RequestParam(value = "phone",required = false)String phone,
                       @RequestParam(value = "langpref",required = false)String languagePreference,
                       @RequestParam(value = "favcategory",required = false)String favouriteCategoryId){
        Account account = accountService.getAccount(id);
        if (password!=null){
            String a = string2MD5(password);
            account.setPassword(a);
        }
        if (email!=null){
            account.setEmail(email);
        }
        if (firstName!=null){
            account.setFirstName(firstName);
        }
        if (lastName!=null){
            account.setLastName(lastName);
        }
        if (status!=null){
            account.setStatus(status);
        }
        if (address1!=null){
            account.setAddress1(address1);
        }
        if (address2!=null){
            account.setAddress2(address2);
        }
        if (city!=null){
            account.setCity(city);
        }
        if (state!=null){
            account.setState(state);
        }
        if (zip!=null){
            account.setZip(zip);
        }
        if (country!=null){
            account.setCountry(country);
        }
        if (phone!=null){
            account.setPhone(phone);
        }
        if (languagePreference!=null){
            account.setLanguagePreference(languagePreference);
        }
        if (favouriteCategoryId!=null){
            account.setFavouriteCategoryId(favouriteCategoryId);
        }
        accountService.updateAccount(account);
    }



//    @PostMapping("newAccount")
//    public String newAccount(String userId,String password,String firstName,String lastName,String email,String phone,String addr1,String addr2,String city,String state,String zip,String country,Model model)
//    {
//        Account account = new Account();
//        account.setUsername(userId);
//        account.setPassword(password);
//        account.setFirstName(firstName);
//        account.setLastName(lastName);
//        account.setEmail(email);
//        account.setPhone(phone);
//        account.setAddress1(addr1);
//        account.setAddress2(addr2);
//        account.setCity(city);
//        account.setState(state);
//        account.setZip(zip);
//        account.setCountry(country);
//        System.out.println(account.toString());
//        accountService.insertAccount(account);
//        return "catalog/main";
//    }


    //由管理员名来获取密码
    @GetMapping("/searchAdminPass/{id}")
    @ResponseBody
    public Admin getAdminPassById(@PathVariable String id) {
        Admin admin = accountService.getAdminById(id);
        return admin;
    }

    //获取所有的管理员
    @GetMapping("/searchAllAdmin")
    @ResponseBody
    public List<Admin>  getAdmin() {
        List<Admin> admins = accountService.getAdminList();
        return admins;
    }

    //修改管理员用户信息
    @PutMapping("/updateAdmin/{id}")
    @ResponseBody
    public void Update(@PathVariable("id")String id,
                       @RequestParam(value = "password",required = false)String password){
        Admin admin = accountService.getAdminById(id);
        if (password!=null){
            admin.setPassword(password);
        }

        accountService.updateAdmin(admin);
    }

}
