describe('Registration link validation', () => {
  it('rejects a registration link without course and section IDs', () => {
    cy.intercept('GET', '**/api/v1/users/exists/*', {
      statusCode: 200,
      body: {
        flag: true,
        code: 200,
        message: 'Email availability checked',
        data: false
      }
    }).as('checkEmailExists')

    cy.visit('/register?email=new.student%40example.edu&token=test-token&role=student')

    cy.wait('@checkEmailExists')
    cy.location('pathname').should('eq', '/403')
    cy.contains('h1', '403').should('be.visible')
  })
})
