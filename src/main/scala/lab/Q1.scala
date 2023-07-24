package lab

import scala.io.StdIn

object Q1 {
  val alphabet = 26

  //Encryption function
  def encryption(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base + shift) % alphabet + base).toChar
      }
      else
        char
    }
  }

  //decryption function
  def decryption(text: String, shift: Int): String = {
    encryption(text, alphabet - shift)
  }

  //Cipher function which takes Encryption and Decryption functions
  def ciper(text:String,shift:Int,func:(String,Int)=>String):String={
    func(text,shift)
  }

  def main(args:Array[String]): Unit = {
    print("Enter the text: ")
    val txt = StdIn.readLine()
    print("Shift by: ");
    val shift = StdIn.readInt()

    //Display encrypted text
    val encryptedTxt = ciper(txt,shift,encryption)
    println("Encrypted text: " + encryptedTxt)

    //Display decrypted text
    println("Decrypted text: " + ciper(encryptedTxt,shift,decryption))

  }
}

