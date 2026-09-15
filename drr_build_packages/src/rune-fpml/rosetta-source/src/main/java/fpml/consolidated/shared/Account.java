package fpml.consolidated.shared;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.shared.meta.AccountMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A generic account that represents any party's account at another party. Parties may be identified by the account at another party.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A generic account that represents any party's account at another party. Parties may be identified by the account at another party.
 *
 */
@RosettaDataType(value="Account", builder=Account.AccountBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Account", model="fpml", builder=Account.AccountBuilderImpl.class, version="2.1.1")
public interface Account extends RosettaModelObject {

	AccountMeta metaData = new AccountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The unique identifier for the account within the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The unique identifier for the account within the document.
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An account identifier. For example an Account number.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An account identifier. For example an Account number.
	 *
	 */
	List<? extends AccountId> getAccountId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The name by which the account is known.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name by which the account is known.
	 *
	 */
	AccountName getAccountName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of account. e.g., Client, House
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of account. e.g., Client, House
	 *
	 */
	AccountType getAccountType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party beneficiary of the account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party beneficiary of the account.
	 *
	 */
	PartyReference getAccountBeneficiary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that services/supports the account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that services/supports the account.
	 *
	 */
	PartyReference getServicingParty();

	/*********************** Build Methods  ***********************/
	Account build();
	
	Account.AccountBuilder toBuilder();
	
	static Account.AccountBuilder builder() {
		return new Account.AccountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Account> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Account> getType() {
		return Account.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("accountId"), processor, AccountId.class, getAccountId());
		processRosetta(path.newSubPath("accountName"), processor, AccountName.class, getAccountName());
		processRosetta(path.newSubPath("accountType"), processor, AccountType.class, getAccountType());
		processRosetta(path.newSubPath("accountBeneficiary"), processor, PartyReference.class, getAccountBeneficiary());
		processRosetta(path.newSubPath("servicingParty"), processor, PartyReference.class, getServicingParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccountBuilder extends Account, RosettaModelObjectBuilder {
		AccountId.AccountIdBuilder getOrCreateAccountId(int index);
		@Override
		List<? extends AccountId.AccountIdBuilder> getAccountId();
		AccountName.AccountNameBuilder getOrCreateAccountName();
		@Override
		AccountName.AccountNameBuilder getAccountName();
		AccountType.AccountTypeBuilder getOrCreateAccountType();
		@Override
		AccountType.AccountTypeBuilder getAccountType();
		PartyReference.PartyReferenceBuilder getOrCreateAccountBeneficiary();
		@Override
		PartyReference.PartyReferenceBuilder getAccountBeneficiary();
		PartyReference.PartyReferenceBuilder getOrCreateServicingParty();
		@Override
		PartyReference.PartyReferenceBuilder getServicingParty();
		Account.AccountBuilder setId(String id);
		Account.AccountBuilder addAccountId(AccountId accountId);
		Account.AccountBuilder addAccountId(AccountId accountId, int idx);
		Account.AccountBuilder addAccountId(List<? extends AccountId> accountId);
		Account.AccountBuilder setAccountId(List<? extends AccountId> accountId);
		Account.AccountBuilder setAccountName(AccountName accountName);
		Account.AccountBuilder setAccountType(AccountType accountType);
		Account.AccountBuilder setAccountBeneficiary(PartyReference accountBeneficiary);
		Account.AccountBuilder setServicingParty(PartyReference servicingParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("accountId"), processor, AccountId.AccountIdBuilder.class, getAccountId());
			processRosetta(path.newSubPath("accountName"), processor, AccountName.AccountNameBuilder.class, getAccountName());
			processRosetta(path.newSubPath("accountType"), processor, AccountType.AccountTypeBuilder.class, getAccountType());
			processRosetta(path.newSubPath("accountBeneficiary"), processor, PartyReference.PartyReferenceBuilder.class, getAccountBeneficiary());
			processRosetta(path.newSubPath("servicingParty"), processor, PartyReference.PartyReferenceBuilder.class, getServicingParty());
		}
		

		Account.AccountBuilder prune();
	}

	/*********************** Immutable Implementation of Account  ***********************/
	class AccountImpl implements Account {
		private final String id;
		private final List<? extends AccountId> accountId;
		private final AccountName accountName;
		private final AccountType accountType;
		private final PartyReference accountBeneficiary;
		private final PartyReference servicingParty;
		
		protected AccountImpl(Account.AccountBuilder builder) {
			this.id = builder.getId();
			this.accountId = ofNullable(builder.getAccountId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accountName = ofNullable(builder.getAccountName()).map(f->f.build()).orElse(null);
			this.accountType = ofNullable(builder.getAccountType()).map(f->f.build()).orElse(null);
			this.accountBeneficiary = ofNullable(builder.getAccountBeneficiary()).map(f->f.build()).orElse(null);
			this.servicingParty = ofNullable(builder.getServicingParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("accountId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accountId")
		public List<? extends AccountId> getAccountId() {
			return accountId;
		}
		
		@Override
		@RosettaAttribute("accountName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountName")
		public AccountName getAccountName() {
			return accountName;
		}
		
		@Override
		@RosettaAttribute("accountType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountType")
		public AccountType getAccountType() {
			return accountType;
		}
		
		@Override
		@RosettaAttribute("accountBeneficiary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountBeneficiary")
		public PartyReference getAccountBeneficiary() {
			return accountBeneficiary;
		}
		
		@Override
		@RosettaAttribute("servicingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("servicingParty")
		public PartyReference getServicingParty() {
			return servicingParty;
		}
		
		@Override
		public Account build() {
			return this;
		}
		
		@Override
		public Account.AccountBuilder toBuilder() {
			Account.AccountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Account.AccountBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAccountId()).ifPresent(builder::setAccountId);
			ofNullable(getAccountName()).ifPresent(builder::setAccountName);
			ofNullable(getAccountType()).ifPresent(builder::setAccountType);
			ofNullable(getAccountBeneficiary()).ifPresent(builder::setAccountBeneficiary);
			ofNullable(getServicingParty()).ifPresent(builder::setServicingParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Account _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(accountId, _that.getAccountId())) return false;
			if (!Objects.equals(accountName, _that.getAccountName())) return false;
			if (!Objects.equals(accountType, _that.getAccountType())) return false;
			if (!Objects.equals(accountBeneficiary, _that.getAccountBeneficiary())) return false;
			if (!Objects.equals(servicingParty, _that.getServicingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (accountId != null ? accountId.hashCode() : 0);
			_result = 31 * _result + (accountName != null ? accountName.hashCode() : 0);
			_result = 31 * _result + (accountType != null ? accountType.hashCode() : 0);
			_result = 31 * _result + (accountBeneficiary != null ? accountBeneficiary.hashCode() : 0);
			_result = 31 * _result + (servicingParty != null ? servicingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Account {" +
				"id=" + this.id + ", " +
				"accountId=" + this.accountId + ", " +
				"accountName=" + this.accountName + ", " +
				"accountType=" + this.accountType + ", " +
				"accountBeneficiary=" + this.accountBeneficiary + ", " +
				"servicingParty=" + this.servicingParty +
			'}';
		}
	}

	/*********************** Builder Implementation of Account  ***********************/
	class AccountBuilderImpl implements Account.AccountBuilder {
	
		protected String id;
		protected List<AccountId.AccountIdBuilder> accountId = new ArrayList<>();
		protected AccountName.AccountNameBuilder accountName;
		protected AccountType.AccountTypeBuilder accountType;
		protected PartyReference.PartyReferenceBuilder accountBeneficiary;
		protected PartyReference.PartyReferenceBuilder servicingParty;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("accountId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accountId")
		public List<? extends AccountId.AccountIdBuilder> getAccountId() {
			return accountId;
		}
		
		@Override
		public AccountId.AccountIdBuilder getOrCreateAccountId(int index) {
			if (accountId==null) {
				this.accountId = new ArrayList<>();
			}
			return getIndex(accountId, index, () -> {
						AccountId.AccountIdBuilder newAccountId = AccountId.builder();
						return newAccountId;
					});
		}
		
		@Override
		@RosettaAttribute("accountName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountName")
		public AccountName.AccountNameBuilder getAccountName() {
			return accountName;
		}
		
		@Override
		public AccountName.AccountNameBuilder getOrCreateAccountName() {
			AccountName.AccountNameBuilder result;
			if (accountName!=null) {
				result = accountName;
			}
			else {
				result = accountName = AccountName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountType")
		public AccountType.AccountTypeBuilder getAccountType() {
			return accountType;
		}
		
		@Override
		public AccountType.AccountTypeBuilder getOrCreateAccountType() {
			AccountType.AccountTypeBuilder result;
			if (accountType!=null) {
				result = accountType;
			}
			else {
				result = accountType = AccountType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountBeneficiary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountBeneficiary")
		public PartyReference.PartyReferenceBuilder getAccountBeneficiary() {
			return accountBeneficiary;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAccountBeneficiary() {
			PartyReference.PartyReferenceBuilder result;
			if (accountBeneficiary!=null) {
				result = accountBeneficiary;
			}
			else {
				result = accountBeneficiary = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("servicingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("servicingParty")
		public PartyReference.PartyReferenceBuilder getServicingParty() {
			return servicingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateServicingParty() {
			PartyReference.PartyReferenceBuilder result;
			if (servicingParty!=null) {
				result = servicingParty;
			}
			else {
				result = servicingParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public Account.AccountBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("accountId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accountId")
		@Override
		public Account.AccountBuilder addAccountId(AccountId _accountId) {
			if (_accountId != null) {
				this.accountId.add(_accountId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Account.AccountBuilder addAccountId(AccountId _accountId, int idx) {
			getIndex(this.accountId, idx, () -> _accountId.toBuilder());
			return this;
		}
		
		@Override
		public Account.AccountBuilder addAccountId(List<? extends AccountId> accountIds) {
			if (accountIds != null) {
				for (final AccountId toAdd : accountIds) {
					this.accountId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accountId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accountId")
		@Override
		public Account.AccountBuilder setAccountId(List<? extends AccountId> accountIds) {
			if (accountIds == null) {
				this.accountId = new ArrayList<>();
			} else {
				this.accountId = accountIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("accountName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountName")
		@Override
		public Account.AccountBuilder setAccountName(AccountName _accountName) {
			this.accountName = _accountName == null ? null : _accountName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountType")
		@Override
		public Account.AccountBuilder setAccountType(AccountType _accountType) {
			this.accountType = _accountType == null ? null : _accountType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountBeneficiary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountBeneficiary")
		@Override
		public Account.AccountBuilder setAccountBeneficiary(PartyReference _accountBeneficiary) {
			this.accountBeneficiary = _accountBeneficiary == null ? null : _accountBeneficiary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("servicingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("servicingParty")
		@Override
		public Account.AccountBuilder setServicingParty(PartyReference _servicingParty) {
			this.servicingParty = _servicingParty == null ? null : _servicingParty.toBuilder();
			return this;
		}
		
		@Override
		public Account build() {
			return new Account.AccountImpl(this);
		}
		
		@Override
		public Account.AccountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Account.AccountBuilder prune() {
			accountId = accountId.stream().filter(b->b!=null).<AccountId.AccountIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (accountName!=null && !accountName.prune().hasData()) accountName = null;
			if (accountType!=null && !accountType.prune().hasData()) accountType = null;
			if (accountBeneficiary!=null && !accountBeneficiary.prune().hasData()) accountBeneficiary = null;
			if (servicingParty!=null && !servicingParty.prune().hasData()) servicingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAccountId()!=null && getAccountId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccountName()!=null && getAccountName().hasData()) return true;
			if (getAccountType()!=null && getAccountType().hasData()) return true;
			if (getAccountBeneficiary()!=null && getAccountBeneficiary().hasData()) return true;
			if (getServicingParty()!=null && getServicingParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Account.AccountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Account.AccountBuilder o = (Account.AccountBuilder) other;
			
			merger.mergeRosetta(getAccountId(), o.getAccountId(), this::getOrCreateAccountId);
			merger.mergeRosetta(getAccountName(), o.getAccountName(), this::setAccountName);
			merger.mergeRosetta(getAccountType(), o.getAccountType(), this::setAccountType);
			merger.mergeRosetta(getAccountBeneficiary(), o.getAccountBeneficiary(), this::setAccountBeneficiary);
			merger.mergeRosetta(getServicingParty(), o.getServicingParty(), this::setServicingParty);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Account _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(accountId, _that.getAccountId())) return false;
			if (!Objects.equals(accountName, _that.getAccountName())) return false;
			if (!Objects.equals(accountType, _that.getAccountType())) return false;
			if (!Objects.equals(accountBeneficiary, _that.getAccountBeneficiary())) return false;
			if (!Objects.equals(servicingParty, _that.getServicingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (accountId != null ? accountId.hashCode() : 0);
			_result = 31 * _result + (accountName != null ? accountName.hashCode() : 0);
			_result = 31 * _result + (accountType != null ? accountType.hashCode() : 0);
			_result = 31 * _result + (accountBeneficiary != null ? accountBeneficiary.hashCode() : 0);
			_result = 31 * _result + (servicingParty != null ? servicingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountBuilder {" +
				"id=" + this.id + ", " +
				"accountId=" + this.accountId + ", " +
				"accountName=" + this.accountName + ", " +
				"accountType=" + this.accountType + ", " +
				"accountBeneficiary=" + this.accountBeneficiary + ", " +
				"servicingParty=" + this.servicingParty +
			'}';
		}
	}
}
