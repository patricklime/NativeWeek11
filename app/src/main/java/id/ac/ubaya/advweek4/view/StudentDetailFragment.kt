package id.ac.ubaya.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.advweek4.R
import id.ac.ubaya.advweek4.databinding.FragmentStudentDetailBinding
import id.ac.ubaya.advweek4.util.loadImage
import id.ac.ubaya.advweek4.viewmodel.DetailViewModel
import id.ac.ubaya.advweek4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentDetailFragment : Fragment(), ButtonUpdateClickListener, ButtonNotifyClickListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding:FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stuid = StudentDetailFragmentArgs.fromBundle(requireArguments()).idUser

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(stuid)

        dataBinding.updateListener = this

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {

//            for(i in it){
//                if(i.id == uuid){
                    dataBinding.student = it
//                    txtID.setText(i.id)
//                    txtName.setText( i.name)
//
//                    imageView2.loadImage(i.photoUrl, this.progressBar)
//
//                    txtBod.setText(i.dob)
//                    txtPhone.append(i.phone)

//                }
//            }

        })
    }

    override fun onButtonUpdateClick(v: View) {

    }

    override fun onButtonNotifyClick(v: View) {

    }


}