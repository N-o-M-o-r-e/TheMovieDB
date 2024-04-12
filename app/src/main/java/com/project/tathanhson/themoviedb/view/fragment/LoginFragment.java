package com.project.tathanhson.themoviedb.view.fragment;

import android.widget.Toast;

import com.project.tathanhson.themoviedb.CommonUtils;
import com.project.tathanhson.themoviedb.R;
import com.project.tathanhson.themoviedb.api.res.SessionRes;
import com.project.tathanhson.themoviedb.databinding.FragmentLoginBinding;
import com.project.tathanhson.themoviedb.view.base.BaseFragment;
import com.project.tathanhson.themoviedb.viewmodel.LoginViewModel;


public class LoginFragment extends BaseFragment<FragmentLoginBinding, LoginViewModel> {
    public static final String TAG = LoginFragment.class.getName();
    public static final String KEY_SESSION_ID = "KEY_SESSION_ID";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public Class<LoginViewModel> initViewModelClass() {
        return LoginViewModel.class;
    }

    @Override
    public FragmentLoginBinding initViewBinding() {
        return FragmentLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    public void initViews() {
        binding.btnLogin.setOnClickListener(view -> viewModel.getAuthen(
//                binding.edtUserName.getText().toString(),
//                binding.edtPassWord.getText().toString()
                "no~more","17022001"
        ));
    }

    @Override
    public void apiError(String key, int code, Object data) {
        if (code == 401){
            Toast.makeText(context, "Tài khoản hoặc mật khẩu không phù hợp", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Error"+code, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void apiSucsess(String key, Object data) {
        if (key.equals(LoginViewModel.KEY_API_CREATE_SESSION_ID)){
            SessionRes res = (SessionRes) data;
            //save sessionID to share preference
            CommonUtils.getInstance().savePref(KEY_SESSION_ID, res.sessionId);
            Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show();
        }
    }
}