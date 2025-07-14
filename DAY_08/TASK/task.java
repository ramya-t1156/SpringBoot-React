// inside AuthService.java

public JwtResponse authenticate(RegisterDetails login) {
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword())
    );

    String token = jwtTokenProvider.generateToken(authentication);
    String username = login.getUserName();
    List<String> roles = authentication.getAuthorities().stream()
            .map(role -> role.getAuthority())
            .collect(Collectors.toList());

    String joinedRoles = String.join(",", roles);
    return new JwtResponse(token, username, joinedRoles);
}
