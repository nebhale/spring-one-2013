# Naive URL Scheme Changes
1.  Add `/naive/v2/owners/{ownerId}/cats` to `CatController` `@RequestMapping`
1.  Add `/naive/v2/owners` to `OwnerController` `@RequestMapping`
1.  Demonstrate both versions of API working
1.  Ask: what if the payload needed to differ?  Explain later

# HATEOAS URL Scheme Changes
1.  Implement `CatResourceAssembler`
1.  Implement `CatController`
1.  Demonstrate the payloads of the `Owner` and `Cat` and how to traverse between them
1.  Change the `CatController` `@RequestMapping` to `/naive/v2/owners/{ownerId}/cats`
1.  Demonstrate that the playloads have changed, but the URIs can be followed with no changes to the client
1.  Ask again: what if the payload needed to differ?  Explain shortly

# Naive Output Changes
1.  Add `produces = "application/vnd.nebhale.cat.v1+json"` to `CatController.readV1()` `@RequestMapping`
1.  Demonstrate the payload headers of `Cat` with `Accept` header
1.  Add a `readV2()` method to `CatController`
1.  Demonstrate the ability to get two different payloads depending on header
1.  Ask: But doesn't having both a `CatV1` and `CatV2` seem like overkill?  They overlap so much.

# JsonView Output Changes
1.  Demonstrate that the payloads for both `Cat` V1 and V2 are identical
1.  Create a `V2` interface in the `Cat` class
1.  Mark `whiskerCount` in `Cat` with `@JsonView`
1.  Mark `readV2` in `CatController` with `@ResponseView`
1.  Demonstrate that the playloads are now filtered
