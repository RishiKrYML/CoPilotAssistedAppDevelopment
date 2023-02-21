# Objective
As GitHub Copilot for Business is now available, we wanted to explore the tangible effect on how much it can help devs. Below we have documented our journey and our thoughts on its usefulness, advantages and disadvantages.

This is a PoC / Exploration done by Madan (madan.ar@ymedialabs.com) for iOS app development and Rishi (rishi.kumar@ymedialabs.com) for Android app development, at YML. 

# 1. Creating a Movie List app in swift using Github Copilot

GitHub Copilot is an in-editor extension for software development that makes suggestions to you as you code, and it is powered by network language model called Codex which was trained on public code repositories on GitHub.

Xcode doesn't have integration of the copilot. But copilot can be used in VSCode and run the app in Xcode

## Creating a data model for movie



https://user-images.githubusercontent.com/97149381/220015011-ac0b4399-3ce3-4ce6-a8bf-963a3beac73b.mov

The Copilot was easily able to create the data model with the given properties. It can also create some random properties based on the file name if we don't define the properties.
It can detect the data type based on the name of the property. In the above code, we can see that it identified the datatype of `id` as `Int`.

## Creating a List to display movie list using table view.


https://user-images.githubusercontent.com/97149381/220015698-02231c9a-2684-4685-a833-fb3eabc4d550.mov

While creating a variable to store the list of movies, we can see that Copilot suggested the array of 'Movie'. The 'Movie' was created in a separate file. It was able to scan files other than the current one.
It suggested the boilerplate required for creating the table view. Using this I was able to create a table view quickly.

## Creating a cell for table view.


https://user-images.githubusercontent.com/97149381/220016739-7e653f1e-245e-4482-be5a-aece0b1aee25.mov

With just one line comment it was able to create a whole class to display movie title and poster.
In the first suggestion, it created a cell based on the data model `Movie` that we created earlier. Then I modified the comment to configure the cell using two parameters title and posterImage instead of `Movie`. It was able to update the code immediately according to the comment..

## Creating a API to fetch movies


https://user-images.githubusercontent.com/97149381/220018212-47ec1ab6-1c95-4d64-9e5d-9bb91a87b4f2.mov

Then I asked Copilot to fetch movies from the given API. It was able to successfully fetch the movies. It has also written code to decode the data from `Movie`, but I had to make some changes manually to 'Movie' to make it decodable.

## Calling the API

https://user-images.githubusercontent.com/97149381/220021560-87a6942e-4195-456c-8968-5a842304c640.mov



By now Copilot has scanned all the files and it was able to predict what I would do next. Just after entering the new line, it suggested to fetch movies from API.


After spending some time refactoring and debugging, I was able to run the app.

https://user-images.githubusercontent.com/97149381/220022601-a2ee44a7-8e20-4c5f-b611-43d90c53f1dd.mov


## Refactoring the code


https://user-images.githubusercontent.com/97149381/220023218-ef67a0b7-5dd5-41df-8bb7-77deddc465d4.mov

Copilot can not only create new code but it can also refactor the old code. In the above example, I tried to change the completion handler and it was able to modify the function according to the updated completion handler.

# 2. Creating a 'Show List of USER from API' Android app using Github Copilot
Fortunately Copilot integration is very easy in Android Studio. We just need to install the plugin and we are good to go. Copilot is compatible with all JetBrain IDEs.
After installing the plugin we need to login to Github. After login we can see the Copilot icon in the right side of the editor.
Once copilot is installed and successfully logged in we can start using it right away.

![image](https://user-images.githubusercontent.com/96165741/220276060-90953e06-3f87-479a-b6a7-6bfd21623969.png)


Journey of code creation using Copilot is very much similar to the one we have seen above in Swift. Copilot can create the data model, compose view ui, API call mechanisms , adding dependencies etc.
If you see codes inside the 'AndroidAppCode' folder then u will find more than 95% of code was generated via Copilot./
As this application was build is in kotlin and kotlin being the fairly new language suggestions were not as good or of high volume as seen in older languages like java,javascript,C++ etc.

# Copilot's pros and cons 
## Advantages:
- **Boilerplate code**:
  It can suggest the boilerplate code quickly which can save the time of switching between code and stackoverflow.
- **Quick snippets**:
  It can provide the code snippets while writing the code which make the typing of the code faster.
- **Learns from local code**:
  Copilot not only learn from public code but it can also analyze and learn from local code that we have written. It save the time of copying the already written code and pasting it.
- **Helps in Solving the problem**:
  Copilot suggestions sometimes helps in solving the problem. It can analyze based on the funtion name and provide the solution.
- **Increased comments in the code**:
  Since we provide the description the code in the comment, it helps others to easily understand the code.

## Disadvantages
- **Most serious disadvantage is The Legal Risks of Copilot**:
  As we are using the code generated by Copilot, we are at the risk of copyright violation. We can use the code but we cannot claim it as our own. Copilot strips code of its licenses, so developers who use it run the risk that they are unwittingly violating copyright. That puts companies at risk of lawsuits. GitHub’s own website states that “about 1% of the time, a suggestion may contain some code snippets longer than ~150 characters that matches the training set, meaning it is directly violating the copyrights by using actual original code written by other developers without any license”. Another great article on this topic: https://www.kolide.com/blog/github-copilot-isn-t-worth-the-risk
- **Privacy : what data does Copilot for Business collect**:
  GitHub Copilot transmits snippets of your code from your IDE to GitHub to provide Suggestions to you. Code snippets data is only transmitted in real-time to return Suggestions, and is discarded once a Suggestion is returned. Copilot for Business does not retain any Code Snippets Data. When you edit files with the GitHub Copilot extension/plugin enabled, file content snippets will be shared with GitHub, Microsoft, and OpenAI, and used for diagnostic purposes to improve suggestions and related products. GitHub Copilot relies on file content for context, both in the file you are editing and potentially other files open in the same IDE instance. Fortunately there is option to disable this action. https://docs.github.com/en/copilot/configuring-github-copilot/configuring-github-copilot-settings-on-githubcom
  More details in official site : https://github.com/features/copilot  
- **Not good for newer language**:
  There just isn't nearly as much training data for new languages/frameworks as there is for older languages like Java, Python, JS, C#, etc.
- **It's not always necessarily accurate or latest**:
  Copilot doesn't give the right suggestion always. Sometimes it cannot understand the instructions given. Also the suggestions could not be upto date.
- **Need to wait for suggestions**:
  We need to wait 2 to 6 seconds after wrting the description of the code to get suggestions which can be annoying.
- **Potentially it could introduce bugs**:
   We may use code without understanding what exactly it is doing. Which may lead to bugs.
- **Not useful for very complex flow or system or a complete end to end solution**
  GitHub Copilot works best when you divide your code into small functions, use meaningful names for functions parameters, and write good docstrings and comments as you go.

# Conclusion
Copilot helped us to reduce the time required to write code and increase productivity. Copilot is awesome but there are a few disadvantages that cannot be overlooked. Copilot can also suggest code that has security flaws and we have the tendency to accept the suggestion without checking the code. Also over time, we would get lazy using Copilot but putting those aside Copilot can be a great helping hand and learning partner.

