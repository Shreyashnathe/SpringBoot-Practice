# Spring OAuth Application

This application demonstrates OAuth2 authentication with Google and GitHub.

## Setup Instructions

1. Copy the `application.properties.template` file to `application.properties`:
   ```bash
   cp src/main/resources/application.properties.template src/main/resources/application.properties
   ```

2. Update the `application.properties` file with your OAuth credentials:
   - Replace `YOUR_GOOGLE_CLIENT_ID` with your Google OAuth Client ID
   - Replace `YOUR_GOOGLE_CLIENT_SECRET` with your Google OAuth Client Secret
   - Replace `YOUR_GITHUB_CLIENT_ID` with your GitHub OAuth Client ID
   - Replace `YOUR_GITHUB_CLIENT_SECRET` with your GitHub OAuth Client Secret

## Getting OAuth Credentials

### Google OAuth
1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project or select an existing one
3. Navigate to "APIs & Services" > "Credentials"
4. Create OAuth 2.0 Client ID
5. Add authorized redirect URIs

### GitHub OAuth
1. Go to [GitHub Developer Settings](https://github.com/settings/developers)
2. Create a new OAuth App
3. Set the callback URL for your application

## Important Security Note

⚠️ **Never commit the `application.properties` file with real credentials to version control!**

The `application.properties` file is already added to `.gitignore` to prevent accidental commits.

