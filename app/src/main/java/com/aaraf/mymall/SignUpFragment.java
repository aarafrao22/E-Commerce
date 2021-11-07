package com.aaraf.mymall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUpFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    private TextView tvAlreadyHave;
    private FrameLayout frameLayout;
    private EditText edEmail, edPassword, edConfirmPassword, edName;
    private Button btnSignUp;
    private ImageButton btnClose;
    private ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        tvAlreadyHave = view.findViewById(R.id.sign_up_already_have);
        edEmail = view.findViewById(R.id.sign_up_email);
        edPassword = view.findViewById(R.id.sign_up_password);
        edConfirmPassword = view.findViewById(R.id.sign_up_confirm_password);
        edName = view.findViewById(R.id.sign_up_f_name);
        btnSignUp = view.findViewById(R.id.btn_sign_up);
        btnClose = view.findViewById(R.id.sign_up_close);
        progressBar = view.findViewById(R.id.sign_up_progressBar);
        frameLayout = getActivity().findViewById(R.id.sign_up_already_have);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvAlreadyHave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });
        edEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent();
            }
        });
    }

    private void mainIntent() {
        Intent MainIntent1 = new Intent(getActivity(), MainActivity2.class);
        startActivity(MainIntent1);
        ((Activity)getActivity()).overridePendingTransition(0,0);
    }

    private void checkEmailAndPassword() {

        Drawable CustomDrawableErrorIcon = getResources().getDrawable(R.drawable.icon_baseline_error_outline);
        CustomDrawableErrorIcon.setBounds(0, 0, CustomDrawableErrorIcon.getIntrinsicWidth(), CustomDrawableErrorIcon.getIntrinsicHeight());
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
        if (edEmail.getText().toString().matches(emailPattern)) {
            if (edPassword.getText().toString().equals(edConfirmPassword.getText().toString())) {

                progressBar.setVisibility(View.VISIBLE);

                btnSignUp.setEnabled(false);
                btnSignUp.setTextColor(Color.argb(50, 255, 255, 255));

                firebaseAuth.createUserWithEmailAndPassword(edEmail.getText().toString(), edPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Map<Object, String> userData = new HashMap<>();
                                    userData.put("fullname", edName.getText().toString());

                                    firebaseFirestore.collection("users").add(userData)
                                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                                    if (task.isSuccessful()) {

                                                        Intent intent = new Intent(getActivity(), MainActivity2.class);
                                                        startActivity(intent);
                                                        getActivity().finish();

                                                    } else {
                                                        progressBar.setVisibility(View.INVISIBLE);
                                                        String error = task.getException().getMessage().toString();
                                                        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                                        btnSignUp.setEnabled(true);
                                                        btnSignUp.setTextColor(Color.rgb(255, 255, 255));
                                                    }
                                                }
                                            });

                                } else {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    String error = task.getException().getMessage().toString();
                                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                    btnSignUp.setEnabled(true);
                                    btnSignUp.setTextColor(Color.rgb(255, 255, 255));

                                }
                            }
                        });
            } else {
                edConfirmPassword.setError("Password doesn't match", CustomDrawableErrorIcon);
            }
        } else {
            edEmail.setError("Invalid Email", CustomDrawableErrorIcon);
        }
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(edEmail.getText())) {
            if (!TextUtils.isEmpty(edName.getText())) {
                if (!TextUtils.isEmpty(edPassword.getText()) && edPassword.length() <= 8) {
                    if (!TextUtils.isEmpty(edConfirmPassword.getText())) {
                        setBtnEnabled();
                    } else {
                        setBtnDisabled();
                    }
                } else {
                    setBtnDisabled();
                }
            } else {
                setBtnDisabled();
            }
        } else {
            setBtnDisabled();
        }
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    public void setBtnEnabled() {
        btnSignUp.setEnabled(true);
        btnSignUp.setTextColor(Color.rgb(255, 255, 255));
    }

    public void setBtnDisabled() {
        btnSignUp.setEnabled(false);
        btnSignUp.setTextColor(Color.argb(50, 255, 255, 255));
    }
}