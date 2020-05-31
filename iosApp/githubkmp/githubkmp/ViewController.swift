//
//  ViewController.swift
//  githubkmp
//
//  Created by Kevin Campos on 31/05/2020.
//  Copyright © 2020 Kevin. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController {

    @IBOutlet weak var greeting: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        greeting.text = Greeting().greeting()
    }


}

