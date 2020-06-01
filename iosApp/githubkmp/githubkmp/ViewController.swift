//
//  ViewController.swift
//  githubkmp
//
//  Created by Kevin Campos on 31/05/2020.
//  Copyright © 2020 Kevin. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController, MembersView {

    lazy var presenter: MembersPresenter = {
        MembersPresenter(view: self, repository: AppDelegate.appDelegate.dataRepository)
    }()
    
    var isUpdating = false
    
    @IBOutlet weak var greeting: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        greeting.text = Greeting().greeting()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        presenter.onCreate()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        presenter.onDestroy()
    }

    func onUpdate(members: Array<Member>) {
        print(members)
    }

}

