package com.example.pet_coctails.core.abstraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject


//TODO  базовый фрагмент по аналогии с базовой активити (проговаривалось в конце записи от 14.07 на 52.50)
abstract class BaseFragment <V: ViewBinding, VM: ViewModel> : Fragment() {

    private var _binding: V? = null
    protected val binding: V
        get() = requireNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var _viewModel: VM
    protected val viewModel: VM
        get() = _viewModel

    override fun onCreate(savedInstanceState: Bundle?) { //TODO не хочет проглатывать onCreateView
        setupDaggerComponent()
        super.onCreate(savedInstanceState)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (_binding == null) {
            _binding = getViewBinding(layoutInflater)
        }
        
        _viewModel = ViewModelProvider(this, viewModelFactory)[getViewModelClass]
        
        
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    open fun initUI() {}

    abstract fun setupDaggerComponent()

    override fun onDestroy() { //TODO не хочет проглатывать onDestroyView
        super.onDestroy()
        
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract val getViewBinding: (LayoutInflater) -> V
    abstract val getViewModelClass: Class<VM>
}