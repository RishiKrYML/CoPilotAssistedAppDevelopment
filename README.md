# Creating a Movie List app in swift using Github Copilot

GitHub Copilot is an in-editor extension for software development that makes suggestions to you as you code, and it is powered by network language model called Codex which was trained on public code repositories on GitHub.

Xcode doesn't have intergration of the copilot. But copilot can be used in VSCode and run the app in Xcode

## Creating a data model for movie



https://user-images.githubusercontent.com/97149381/220015011-ac0b4399-3ce3-4ce6-a8bf-963a3beac73b.mov

The Copilot was easily able to create the data model with the given properties. It can also create some random properties based on file name if we don't define the properties.
It can detect the data type based on name of property. In the above code we can see that it identified the datatype of `id` as `Int`.

## Creating a List to display movie list using table view.


https://user-images.githubusercontent.com/97149381/220015698-02231c9a-2684-4685-a833-fb3eabc4d550.mov

While creating a variable to store the list of movies, we can see that Copilot suggested the array of 'Movie'. The 'Movie' was created in separate file. It was able to scan the files other than the current one.
It suggested the boilerplate required for creating the table view. Using this I was able create a table view quickly.

## Creating a cell for table view.


https://user-images.githubusercontent.com/97149381/220016739-7e653f1e-245e-4482-be5a-aece0b1aee25.mov

With just one line comment it was able create whole class to display movie title and poster.
In the first suggestion it created the cell based on the data model `Movie` that we have created earlier. Then I have modified the comment to take two parameters title and posterImage instead of `Movie . It was able to change the code immediately with updated parameters.

## Creating a API to fetch movies


https://user-images.githubusercontent.com/97149381/220018212-47ec1ab6-1c95-4d64-9e5d-9bb91a87b4f2.mov

I asked Copilot to fetch movies from the give API. It was able to successfully fetch the movies. It has written a line to decode the data from `Movie`, but I had to make some changes manually to 'Movie' to make it decodable.

## Calling the API

https://user-images.githubusercontent.com/97149381/220021560-87a6942e-4195-456c-8968-5a842304c640.mov



By now Copilot has scanned all the files and it was able to predict what I would do next. It had suggested to call the API just by entering new line.


After spending some time refactoring and debugging, I was able to run the app.

https://user-images.githubusercontent.com/97149381/220022601-a2ee44a7-8e20-4c5f-b611-43d90c53f1dd.mov


## Refactoring the code


https://user-images.githubusercontent.com/97149381/220023218-ef67a0b7-5dd5-41df-8bb7-77deddc465d4.mov

Copilot can not only create new code but it can aslo refactor the old code. I the above example I tried the chage the completion handler and it was able to regenerate the whole function using the updated completion handler.

# Copilot's pros and cons 
## Advantages:
- **Boilerplate code**:
  It can suggest the boilerplate code quickly which can save the time of switching between code and stackoverflow.
- **Quick snippets**:
  It can provide the code snippets while writing the code which make the typing of the code faster.
- **Learns from local code**:
  Copilot not only learn from public code but it can also analyze and learn from local code that we have written. It save the time of copying the already written code and pasting it.
- **Helps in Solving the problem**:
  Copilot suggestions sometimes helps in solving the problem. I can analyze based on the funtion name and provide the solution.
- **Increased comments in the code**:
  Since we provide the description the code in the comment, it helps others to easily understand the code.

## Disadvantages
- **It's not alway accurate**:
  Copilot doesn't give the right suggestion always. Sometimes it cannot understand the instructions given.
- **Need to wait for suggestions**:
  We need to wait 2 to 6 seconds after wrting the description of the code to get suggestions which can be annoying.
- **Need more time in debugging**:
  Since we don't write every line of the code using Copilot it is difficult to find the bug.
- We may wirte code without understanding what exactly it is doing. Which may lead to bugs.
