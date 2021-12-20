package com.example.sarvasva.app.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.sarvasva.R;
import com.example.sarvasva.app.activities.MainActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
//
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {

    private TextView forgotPassTv, signUpTv;
    private FrameLayout parentFrameLayout;
    private ImageView close;
    private EditText emailEt, passEt;
//    private FirebaseAuth auth ;
    private Button loginBtn;
    private ProgressBar progressBar;



    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        forgotPassTv = view.findViewById(R.id.forgetPass);
        signUpTv = view.findViewById(R.id.signUpBtn);
        close = view.findViewById(R.id.closeBtn);
        emailEt = view.findViewById(R.id.emailEt);
        passEt = view.findViewById(R.id.passwordEt);
        loginBtn = view.findViewById(R.id.loginBtn);
        progressBar = view.findViewById(R.id.progLoginBar);



        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        parentFrameLayout = getActivity().findViewById(R.id.frameLayoutAuth);
//        auth = FirebaseAuth.getInstance();




//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!emailEt.getText().toString().equals(""))
//                {
//                    if (!passEt.getText().toString().equals(""))
//                    {
//                        //authenticate
//                        loginBtn.setEnabled(false);
//                        progressBar.setVisibility(View.VISIBLE);
//
//                        loginBtn.setText("");
//
//                        try {
//
//                            String email = emailEt.getText().toString().trim();
//                            String pass = passEt.getText().toString().trim();
//
//                            auth.signInWithEmailAndPassword(email , pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//
//                                    if (task.isSuccessful())
//                                    {
//                                        Intent intent = new Intent(getContext(), MainActivity.class);
//                                        Toast.makeText(getContext(), "Logged In!", Toast.LENGTH_SHORT).show();
//                                        startActivity(intent);
//                                        getActivity().finish();
//                                    }
//                                    else
//                                    {
//                                        Toast.makeText(getContext(), "Some Error Occured" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                                        loginBtn.setEnabled(true);
//                                    }
//                                }
//
//                            });
//
//                        }
//                        catch (Exception e)
//                        {
//                            e.printStackTrace();
//                        }
//
//
//                    }
//                    else
//                    {
//                        passEt.setError("Please Enter The Password");
//                    }
//
//                }
//                else {
//                    passEt.setError("Please Enter The EMAIL");
//
//                }
//                progressBar.setVisibility(View.INVISIBLE);
//
//                loginBtn.setText("Login");
//
//
//            }
//        });





        forgotPassTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                isLoginFragment = false;
                changeFragment(new ForgotPasswordFragment());

            }
        });
        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                isLoginFragment = false;
                changeFragment(new SignUpFragment());

            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });


    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit(); }
}


