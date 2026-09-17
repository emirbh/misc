package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.legaldocumentation.csa.meta.CustodianElectionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the custodian and custody account details for each party to the agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="CustodianElection", builder=CustodianElection.CustodianElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CustodianElection", model="cdm", builder=CustodianElection.CustodianElectionBuilderImpl.class, version="6.23.0")
public interface CustodianElection extends RosettaModelObject {

	CustodianElectionMeta metaData = new CustodianElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The custody agent. While CreateiQ only specifies the custodian&#39;s name, specifying the legal entity as part of the CDM is deemed more appropriate, while this will still provide the ability to accommodate situations where only the entity name is available, as the entityId attribute is optional as part of the LegalEntity class.
	 */
	LegalEntity getCustodian();
	/**
	 * The identification of the segregated cash account for the purpose of holding cash collateral.
	 */
	Account getSegregatedCashAccount();
	/**
	 * The identification of the segregated security account for the purpose of holding security collateral.
	 */
	Account getSegregatedSecurityAccount();
	/**
	 * Details how the Custodian is determined.
	 */
	LegacyVMCustodianEnum getLegacyVMCustodian();
	/**
	 * The identity of the relevant custodian where Named Entity is elected.
	 */
	LegalEntity getLegacyNamedEntity();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	CustodianElection build();
	
	CustodianElection.CustodianElectionBuilder toBuilder();
	
	static CustodianElection.CustodianElectionBuilder builder() {
		return new CustodianElection.CustodianElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustodianElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustodianElection> getType() {
		return CustodianElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processRosetta(path.newSubPath("custodian"), processor, LegalEntity.class, getCustodian());
		processRosetta(path.newSubPath("segregatedCashAccount"), processor, Account.class, getSegregatedCashAccount());
		processRosetta(path.newSubPath("segregatedSecurityAccount"), processor, Account.class, getSegregatedSecurityAccount());
		processor.processBasic(path.newSubPath("legacyVMCustodian"), LegacyVMCustodianEnum.class, getLegacyVMCustodian(), this);
		processRosetta(path.newSubPath("legacyNamedEntity"), processor, LegalEntity.class, getLegacyNamedEntity());
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustodianElectionBuilder extends CustodianElection, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateCustodian();
		@Override
		LegalEntity.LegalEntityBuilder getCustodian();
		Account.AccountBuilder getOrCreateSegregatedCashAccount();
		@Override
		Account.AccountBuilder getSegregatedCashAccount();
		Account.AccountBuilder getOrCreateSegregatedSecurityAccount();
		@Override
		Account.AccountBuilder getSegregatedSecurityAccount();
		LegalEntity.LegalEntityBuilder getOrCreateLegacyNamedEntity();
		@Override
		LegalEntity.LegalEntityBuilder getLegacyNamedEntity();
		CustodianElection.CustodianElectionBuilder setParty(CounterpartyRoleEnum party);
		CustodianElection.CustodianElectionBuilder setCustodian(LegalEntity custodian);
		CustodianElection.CustodianElectionBuilder setSegregatedCashAccount(Account segregatedCashAccount);
		CustodianElection.CustodianElectionBuilder setSegregatedSecurityAccount(Account segregatedSecurityAccount);
		CustodianElection.CustodianElectionBuilder setLegacyVMCustodian(LegacyVMCustodianEnum legacyVMCustodian);
		CustodianElection.CustodianElectionBuilder setLegacyNamedEntity(LegalEntity legacyNamedEntity);
		CustodianElection.CustodianElectionBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processRosetta(path.newSubPath("custodian"), processor, LegalEntity.LegalEntityBuilder.class, getCustodian());
			processRosetta(path.newSubPath("segregatedCashAccount"), processor, Account.AccountBuilder.class, getSegregatedCashAccount());
			processRosetta(path.newSubPath("segregatedSecurityAccount"), processor, Account.AccountBuilder.class, getSegregatedSecurityAccount());
			processor.processBasic(path.newSubPath("legacyVMCustodian"), LegacyVMCustodianEnum.class, getLegacyVMCustodian(), this);
			processRosetta(path.newSubPath("legacyNamedEntity"), processor, LegalEntity.LegalEntityBuilder.class, getLegacyNamedEntity());
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		CustodianElection.CustodianElectionBuilder prune();
	}

	/*********************** Immutable Implementation of CustodianElection  ***********************/
	class CustodianElectionImpl implements CustodianElection {
		private final CounterpartyRoleEnum party;
		private final LegalEntity custodian;
		private final Account segregatedCashAccount;
		private final Account segregatedSecurityAccount;
		private final LegacyVMCustodianEnum legacyVMCustodian;
		private final LegalEntity legacyNamedEntity;
		private final String additionalLanguage;
		
		protected CustodianElectionImpl(CustodianElection.CustodianElectionBuilder builder) {
			this.party = builder.getParty();
			this.custodian = ofNullable(builder.getCustodian()).map(f->f.build()).orElse(null);
			this.segregatedCashAccount = ofNullable(builder.getSegregatedCashAccount()).map(f->f.build()).orElse(null);
			this.segregatedSecurityAccount = ofNullable(builder.getSegregatedSecurityAccount()).map(f->f.build()).orElse(null);
			this.legacyVMCustodian = builder.getLegacyVMCustodian();
			this.legacyNamedEntity = ofNullable(builder.getLegacyNamedEntity()).map(f->f.build()).orElse(null);
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("custodian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodian")
		public LegalEntity getCustodian() {
			return custodian;
		}
		
		@Override
		@RosettaAttribute("segregatedCashAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("segregatedCashAccount")
		public Account getSegregatedCashAccount() {
			return segregatedCashAccount;
		}
		
		@Override
		@RosettaAttribute("segregatedSecurityAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("segregatedSecurityAccount")
		public Account getSegregatedSecurityAccount() {
			return segregatedSecurityAccount;
		}
		
		@Override
		@RosettaAttribute("legacyVMCustodian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyVMCustodian")
		public LegacyVMCustodianEnum getLegacyVMCustodian() {
			return legacyVMCustodian;
		}
		
		@Override
		@RosettaAttribute("legacyNamedEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyNamedEntity")
		public LegalEntity getLegacyNamedEntity() {
			return legacyNamedEntity;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public CustodianElection build() {
			return this;
		}
		
		@Override
		public CustodianElection.CustodianElectionBuilder toBuilder() {
			CustodianElection.CustodianElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianElection.CustodianElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getCustodian()).ifPresent(builder::setCustodian);
			ofNullable(getSegregatedCashAccount()).ifPresent(builder::setSegregatedCashAccount);
			ofNullable(getSegregatedSecurityAccount()).ifPresent(builder::setSegregatedSecurityAccount);
			ofNullable(getLegacyVMCustodian()).ifPresent(builder::setLegacyVMCustodian);
			ofNullable(getLegacyNamedEntity()).ifPresent(builder::setLegacyNamedEntity);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(custodian, _that.getCustodian())) return false;
			if (!Objects.equals(segregatedCashAccount, _that.getSegregatedCashAccount())) return false;
			if (!Objects.equals(segregatedSecurityAccount, _that.getSegregatedSecurityAccount())) return false;
			if (!Objects.equals(legacyVMCustodian, _that.getLegacyVMCustodian())) return false;
			if (!Objects.equals(legacyNamedEntity, _that.getLegacyNamedEntity())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (custodian != null ? custodian.hashCode() : 0);
			_result = 31 * _result + (segregatedCashAccount != null ? segregatedCashAccount.hashCode() : 0);
			_result = 31 * _result + (segregatedSecurityAccount != null ? segregatedSecurityAccount.hashCode() : 0);
			_result = 31 * _result + (legacyVMCustodian != null ? legacyVMCustodian.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (legacyNamedEntity != null ? legacyNamedEntity.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianElection {" +
				"party=" + this.party + ", " +
				"custodian=" + this.custodian + ", " +
				"segregatedCashAccount=" + this.segregatedCashAccount + ", " +
				"segregatedSecurityAccount=" + this.segregatedSecurityAccount + ", " +
				"legacyVMCustodian=" + this.legacyVMCustodian + ", " +
				"legacyNamedEntity=" + this.legacyNamedEntity + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of CustodianElection  ***********************/
	class CustodianElectionBuilderImpl implements CustodianElection.CustodianElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected LegalEntity.LegalEntityBuilder custodian;
		protected Account.AccountBuilder segregatedCashAccount;
		protected Account.AccountBuilder segregatedSecurityAccount;
		protected LegacyVMCustodianEnum legacyVMCustodian;
		protected LegalEntity.LegalEntityBuilder legacyNamedEntity;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("custodian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodian")
		public LegalEntity.LegalEntityBuilder getCustodian() {
			return custodian;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateCustodian() {
			LegalEntity.LegalEntityBuilder result;
			if (custodian!=null) {
				result = custodian;
			}
			else {
				result = custodian = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("segregatedCashAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("segregatedCashAccount")
		public Account.AccountBuilder getSegregatedCashAccount() {
			return segregatedCashAccount;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateSegregatedCashAccount() {
			Account.AccountBuilder result;
			if (segregatedCashAccount!=null) {
				result = segregatedCashAccount;
			}
			else {
				result = segregatedCashAccount = Account.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("segregatedSecurityAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("segregatedSecurityAccount")
		public Account.AccountBuilder getSegregatedSecurityAccount() {
			return segregatedSecurityAccount;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateSegregatedSecurityAccount() {
			Account.AccountBuilder result;
			if (segregatedSecurityAccount!=null) {
				result = segregatedSecurityAccount;
			}
			else {
				result = segregatedSecurityAccount = Account.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyVMCustodian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyVMCustodian")
		public LegacyVMCustodianEnum getLegacyVMCustodian() {
			return legacyVMCustodian;
		}
		
		@Override
		@RosettaAttribute("legacyNamedEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyNamedEntity")
		public LegalEntity.LegalEntityBuilder getLegacyNamedEntity() {
			return legacyNamedEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateLegacyNamedEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (legacyNamedEntity!=null) {
				result = legacyNamedEntity;
			}
			else {
				result = legacyNamedEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public CustodianElection.CustodianElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("custodian")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("custodian")
		@Override
		public CustodianElection.CustodianElectionBuilder setCustodian(LegalEntity _custodian) {
			this.custodian = _custodian == null ? null : _custodian.toBuilder();
			return this;
		}
		
		@RosettaAttribute("segregatedCashAccount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("segregatedCashAccount")
		@Override
		public CustodianElection.CustodianElectionBuilder setSegregatedCashAccount(Account _segregatedCashAccount) {
			this.segregatedCashAccount = _segregatedCashAccount == null ? null : _segregatedCashAccount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("segregatedSecurityAccount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("segregatedSecurityAccount")
		@Override
		public CustodianElection.CustodianElectionBuilder setSegregatedSecurityAccount(Account _segregatedSecurityAccount) {
			this.segregatedSecurityAccount = _segregatedSecurityAccount == null ? null : _segregatedSecurityAccount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyVMCustodian")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyVMCustodian")
		@Override
		public CustodianElection.CustodianElectionBuilder setLegacyVMCustodian(LegacyVMCustodianEnum _legacyVMCustodian) {
			this.legacyVMCustodian = _legacyVMCustodian == null ? null : _legacyVMCustodian;
			return this;
		}
		
		@RosettaAttribute("legacyNamedEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyNamedEntity")
		@Override
		public CustodianElection.CustodianElectionBuilder setLegacyNamedEntity(LegalEntity _legacyNamedEntity) {
			this.legacyNamedEntity = _legacyNamedEntity == null ? null : _legacyNamedEntity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public CustodianElection.CustodianElectionBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public CustodianElection build() {
			return new CustodianElection.CustodianElectionImpl(this);
		}
		
		@Override
		public CustodianElection.CustodianElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianElection.CustodianElectionBuilder prune() {
			if (custodian!=null && !custodian.prune().hasData()) custodian = null;
			if (segregatedCashAccount!=null && !segregatedCashAccount.prune().hasData()) segregatedCashAccount = null;
			if (segregatedSecurityAccount!=null && !segregatedSecurityAccount.prune().hasData()) segregatedSecurityAccount = null;
			if (legacyNamedEntity!=null && !legacyNamedEntity.prune().hasData()) legacyNamedEntity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getCustodian()!=null && getCustodian().hasData()) return true;
			if (getSegregatedCashAccount()!=null && getSegregatedCashAccount().hasData()) return true;
			if (getSegregatedSecurityAccount()!=null && getSegregatedSecurityAccount().hasData()) return true;
			if (getLegacyVMCustodian()!=null) return true;
			if (getLegacyNamedEntity()!=null && getLegacyNamedEntity().hasData()) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianElection.CustodianElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianElection.CustodianElectionBuilder o = (CustodianElection.CustodianElectionBuilder) other;
			
			merger.mergeRosetta(getCustodian(), o.getCustodian(), this::setCustodian);
			merger.mergeRosetta(getSegregatedCashAccount(), o.getSegregatedCashAccount(), this::setSegregatedCashAccount);
			merger.mergeRosetta(getSegregatedSecurityAccount(), o.getSegregatedSecurityAccount(), this::setSegregatedSecurityAccount);
			merger.mergeRosetta(getLegacyNamedEntity(), o.getLegacyNamedEntity(), this::setLegacyNamedEntity);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getLegacyVMCustodian(), o.getLegacyVMCustodian(), this::setLegacyVMCustodian);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(custodian, _that.getCustodian())) return false;
			if (!Objects.equals(segregatedCashAccount, _that.getSegregatedCashAccount())) return false;
			if (!Objects.equals(segregatedSecurityAccount, _that.getSegregatedSecurityAccount())) return false;
			if (!Objects.equals(legacyVMCustodian, _that.getLegacyVMCustodian())) return false;
			if (!Objects.equals(legacyNamedEntity, _that.getLegacyNamedEntity())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (custodian != null ? custodian.hashCode() : 0);
			_result = 31 * _result + (segregatedCashAccount != null ? segregatedCashAccount.hashCode() : 0);
			_result = 31 * _result + (segregatedSecurityAccount != null ? segregatedSecurityAccount.hashCode() : 0);
			_result = 31 * _result + (legacyVMCustodian != null ? legacyVMCustodian.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (legacyNamedEntity != null ? legacyNamedEntity.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianElectionBuilder {" +
				"party=" + this.party + ", " +
				"custodian=" + this.custodian + ", " +
				"segregatedCashAccount=" + this.segregatedCashAccount + ", " +
				"segregatedSecurityAccount=" + this.segregatedSecurityAccount + ", " +
				"legacyVMCustodian=" + this.legacyVMCustodian + ", " +
				"legacyNamedEntity=" + this.legacyNamedEntity + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
