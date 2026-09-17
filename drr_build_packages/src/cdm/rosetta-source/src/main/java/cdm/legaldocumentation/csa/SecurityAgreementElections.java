package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.Account;
import cdm.legaldocumentation.csa.meta.SecurityAgreementElectionsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
 * The set of elections which specify a Security Agremeent.
 * @version 6.23.0
 */
@RosettaDataType(value="SecurityAgreementElections", builder=SecurityAgreementElections.SecurityAgreementElectionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SecurityAgreementElections", model="cdm", builder=SecurityAgreementElections.SecurityAgreementElectionsBuilderImpl.class, version="6.23.0")
public interface SecurityAgreementElections extends RosettaModelObject {

	SecurityAgreementElectionsMeta metaData = new SecurityAgreementElectionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The pledged account associated with the agreement.
	 */
	Account getPledgedAccount();
	/**
	 * Enforcement Events specific to the agreement.
	 */
	EnforcementEvent getEnforcementEvent();
	/**
	 * Delivery In Lieu rights.
	 */
	Boolean getDeliveryInLieuRight();
	/**
	 * Full Discharge condition.
	 */
	Boolean getFullDischarge();
	/**
	 * The election for the Valuation of Appropriate Collateral.
	 */
	AppropriatedCollateralValuation getAppropriatedCollateralValuation();
	/**
	 * The Process Agent that might be appointed by the parties to the agreement.
	 */
	ProcessAgent getProcessAgent();
	/**
	 * The jurisdiction specific terms.
	 */
	JurisdictionRelatedTerms getJurisdictionRelatedTerms();
	/**
	 * Any additional amendments that might be specified by the parties to the agreement.
	 */
	String getAdditionalAmendments();
	/**
	 * Any additional terms that might be specified applicable.
	 */
	String getAdditionalBespokeTerms();
	/**
	 * The location and language of execution to determine duty to be paid.
	 */
	ExecutionTerms getExecutionTerms();

	/*********************** Build Methods  ***********************/
	SecurityAgreementElections build();
	
	SecurityAgreementElections.SecurityAgreementElectionsBuilder toBuilder();
	
	static SecurityAgreementElections.SecurityAgreementElectionsBuilder builder() {
		return new SecurityAgreementElections.SecurityAgreementElectionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityAgreementElections> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityAgreementElections> getType() {
		return SecurityAgreementElections.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pledgedAccount"), processor, Account.class, getPledgedAccount());
		processRosetta(path.newSubPath("enforcementEvent"), processor, EnforcementEvent.class, getEnforcementEvent());
		processor.processBasic(path.newSubPath("deliveryInLieuRight"), Boolean.class, getDeliveryInLieuRight(), this);
		processor.processBasic(path.newSubPath("fullDischarge"), Boolean.class, getFullDischarge(), this);
		processRosetta(path.newSubPath("appropriatedCollateralValuation"), processor, AppropriatedCollateralValuation.class, getAppropriatedCollateralValuation());
		processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.class, getProcessAgent());
		processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.class, getJurisdictionRelatedTerms());
		processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
		processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
		processRosetta(path.newSubPath("executionTerms"), processor, ExecutionTerms.class, getExecutionTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityAgreementElectionsBuilder extends SecurityAgreementElections, RosettaModelObjectBuilder {
		Account.AccountBuilder getOrCreatePledgedAccount();
		@Override
		Account.AccountBuilder getPledgedAccount();
		EnforcementEvent.EnforcementEventBuilder getOrCreateEnforcementEvent();
		@Override
		EnforcementEvent.EnforcementEventBuilder getEnforcementEvent();
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getOrCreateAppropriatedCollateralValuation();
		@Override
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getAppropriatedCollateralValuation();
		ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent();
		@Override
		ProcessAgent.ProcessAgentBuilder getProcessAgent();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms();
		@Override
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms();
		ExecutionTerms.ExecutionTermsBuilder getOrCreateExecutionTerms();
		@Override
		ExecutionTerms.ExecutionTermsBuilder getExecutionTerms();
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setPledgedAccount(Account pledgedAccount);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setEnforcementEvent(EnforcementEvent enforcementEvent);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setDeliveryInLieuRight(Boolean deliveryInLieuRight);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setFullDischarge(Boolean fullDischarge);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setAppropriatedCollateralValuation(AppropriatedCollateralValuation appropriatedCollateralValuation);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setProcessAgent(ProcessAgent processAgent);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms jurisdictionRelatedTerms);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setAdditionalAmendments(String additionalAmendments);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setAdditionalBespokeTerms(String additionalBespokeTerms);
		SecurityAgreementElections.SecurityAgreementElectionsBuilder setExecutionTerms(ExecutionTerms executionTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pledgedAccount"), processor, Account.AccountBuilder.class, getPledgedAccount());
			processRosetta(path.newSubPath("enforcementEvent"), processor, EnforcementEvent.EnforcementEventBuilder.class, getEnforcementEvent());
			processor.processBasic(path.newSubPath("deliveryInLieuRight"), Boolean.class, getDeliveryInLieuRight(), this);
			processor.processBasic(path.newSubPath("fullDischarge"), Boolean.class, getFullDischarge(), this);
			processRosetta(path.newSubPath("appropriatedCollateralValuation"), processor, AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder.class, getAppropriatedCollateralValuation());
			processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.ProcessAgentBuilder.class, getProcessAgent());
			processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder.class, getJurisdictionRelatedTerms());
			processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
			processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
			processRosetta(path.newSubPath("executionTerms"), processor, ExecutionTerms.ExecutionTermsBuilder.class, getExecutionTerms());
		}
		

		SecurityAgreementElections.SecurityAgreementElectionsBuilder prune();
	}

	/*********************** Immutable Implementation of SecurityAgreementElections  ***********************/
	class SecurityAgreementElectionsImpl implements SecurityAgreementElections {
		private final Account pledgedAccount;
		private final EnforcementEvent enforcementEvent;
		private final Boolean deliveryInLieuRight;
		private final Boolean fullDischarge;
		private final AppropriatedCollateralValuation appropriatedCollateralValuation;
		private final ProcessAgent processAgent;
		private final JurisdictionRelatedTerms jurisdictionRelatedTerms;
		private final String additionalAmendments;
		private final String additionalBespokeTerms;
		private final ExecutionTerms executionTerms;
		
		protected SecurityAgreementElectionsImpl(SecurityAgreementElections.SecurityAgreementElectionsBuilder builder) {
			this.pledgedAccount = ofNullable(builder.getPledgedAccount()).map(f->f.build()).orElse(null);
			this.enforcementEvent = ofNullable(builder.getEnforcementEvent()).map(f->f.build()).orElse(null);
			this.deliveryInLieuRight = builder.getDeliveryInLieuRight();
			this.fullDischarge = builder.getFullDischarge();
			this.appropriatedCollateralValuation = ofNullable(builder.getAppropriatedCollateralValuation()).map(f->f.build()).orElse(null);
			this.processAgent = ofNullable(builder.getProcessAgent()).map(f->f.build()).orElse(null);
			this.jurisdictionRelatedTerms = ofNullable(builder.getJurisdictionRelatedTerms()).map(f->f.build()).orElse(null);
			this.additionalAmendments = builder.getAdditionalAmendments();
			this.additionalBespokeTerms = builder.getAdditionalBespokeTerms();
			this.executionTerms = ofNullable(builder.getExecutionTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pledgedAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pledgedAccount")
		public Account getPledgedAccount() {
			return pledgedAccount;
		}
		
		@Override
		@RosettaAttribute("enforcementEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enforcementEvent")
		public EnforcementEvent getEnforcementEvent() {
			return enforcementEvent;
		}
		
		@Override
		@RosettaAttribute("deliveryInLieuRight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryInLieuRight")
		public Boolean getDeliveryInLieuRight() {
			return deliveryInLieuRight;
		}
		
		@Override
		@RosettaAttribute("fullDischarge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullDischarge")
		public Boolean getFullDischarge() {
			return fullDischarge;
		}
		
		@Override
		@RosettaAttribute("appropriatedCollateralValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("appropriatedCollateralValuation")
		public AppropriatedCollateralValuation getAppropriatedCollateralValuation() {
			return appropriatedCollateralValuation;
		}
		
		@Override
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("processAgent")
		public ProcessAgent getProcessAgent() {
			return processAgent;
		}
		
		@Override
		@RosettaAttribute("jurisdictionRelatedTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("jurisdictionRelatedTerms")
		public JurisdictionRelatedTerms getJurisdictionRelatedTerms() {
			return jurisdictionRelatedTerms;
		}
		
		@Override
		@RosettaAttribute("additionalAmendments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalAmendments")
		public String getAdditionalAmendments() {
			return additionalAmendments;
		}
		
		@Override
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalBespokeTerms")
		public String getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		@RosettaAttribute("executionTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionTerms")
		public ExecutionTerms getExecutionTerms() {
			return executionTerms;
		}
		
		@Override
		public SecurityAgreementElections build() {
			return this;
		}
		
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder toBuilder() {
			SecurityAgreementElections.SecurityAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityAgreementElections.SecurityAgreementElectionsBuilder builder) {
			ofNullable(getPledgedAccount()).ifPresent(builder::setPledgedAccount);
			ofNullable(getEnforcementEvent()).ifPresent(builder::setEnforcementEvent);
			ofNullable(getDeliveryInLieuRight()).ifPresent(builder::setDeliveryInLieuRight);
			ofNullable(getFullDischarge()).ifPresent(builder::setFullDischarge);
			ofNullable(getAppropriatedCollateralValuation()).ifPresent(builder::setAppropriatedCollateralValuation);
			ofNullable(getProcessAgent()).ifPresent(builder::setProcessAgent);
			ofNullable(getJurisdictionRelatedTerms()).ifPresent(builder::setJurisdictionRelatedTerms);
			ofNullable(getAdditionalAmendments()).ifPresent(builder::setAdditionalAmendments);
			ofNullable(getAdditionalBespokeTerms()).ifPresent(builder::setAdditionalBespokeTerms);
			ofNullable(getExecutionTerms()).ifPresent(builder::setExecutionTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(pledgedAccount, _that.getPledgedAccount())) return false;
			if (!Objects.equals(enforcementEvent, _that.getEnforcementEvent())) return false;
			if (!Objects.equals(deliveryInLieuRight, _that.getDeliveryInLieuRight())) return false;
			if (!Objects.equals(fullDischarge, _that.getFullDischarge())) return false;
			if (!Objects.equals(appropriatedCollateralValuation, _that.getAppropriatedCollateralValuation())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(executionTerms, _that.getExecutionTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pledgedAccount != null ? pledgedAccount.hashCode() : 0);
			_result = 31 * _result + (enforcementEvent != null ? enforcementEvent.hashCode() : 0);
			_result = 31 * _result + (deliveryInLieuRight != null ? deliveryInLieuRight.hashCode() : 0);
			_result = 31 * _result + (fullDischarge != null ? fullDischarge.hashCode() : 0);
			_result = 31 * _result + (appropriatedCollateralValuation != null ? appropriatedCollateralValuation.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (executionTerms != null ? executionTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityAgreementElections {" +
				"pledgedAccount=" + this.pledgedAccount + ", " +
				"enforcementEvent=" + this.enforcementEvent + ", " +
				"deliveryInLieuRight=" + this.deliveryInLieuRight + ", " +
				"fullDischarge=" + this.fullDischarge + ", " +
				"appropriatedCollateralValuation=" + this.appropriatedCollateralValuation + ", " +
				"processAgent=" + this.processAgent + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"executionTerms=" + this.executionTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of SecurityAgreementElections  ***********************/
	class SecurityAgreementElectionsBuilderImpl implements SecurityAgreementElections.SecurityAgreementElectionsBuilder {
	
		protected Account.AccountBuilder pledgedAccount;
		protected EnforcementEvent.EnforcementEventBuilder enforcementEvent;
		protected Boolean deliveryInLieuRight;
		protected Boolean fullDischarge;
		protected AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder appropriatedCollateralValuation;
		protected ProcessAgent.ProcessAgentBuilder processAgent;
		protected JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder jurisdictionRelatedTerms;
		protected String additionalAmendments;
		protected String additionalBespokeTerms;
		protected ExecutionTerms.ExecutionTermsBuilder executionTerms;
		
		@Override
		@RosettaAttribute("pledgedAccount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pledgedAccount")
		public Account.AccountBuilder getPledgedAccount() {
			return pledgedAccount;
		}
		
		@Override
		public Account.AccountBuilder getOrCreatePledgedAccount() {
			Account.AccountBuilder result;
			if (pledgedAccount!=null) {
				result = pledgedAccount;
			}
			else {
				result = pledgedAccount = Account.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("enforcementEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enforcementEvent")
		public EnforcementEvent.EnforcementEventBuilder getEnforcementEvent() {
			return enforcementEvent;
		}
		
		@Override
		public EnforcementEvent.EnforcementEventBuilder getOrCreateEnforcementEvent() {
			EnforcementEvent.EnforcementEventBuilder result;
			if (enforcementEvent!=null) {
				result = enforcementEvent;
			}
			else {
				result = enforcementEvent = EnforcementEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryInLieuRight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryInLieuRight")
		public Boolean getDeliveryInLieuRight() {
			return deliveryInLieuRight;
		}
		
		@Override
		@RosettaAttribute("fullDischarge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullDischarge")
		public Boolean getFullDischarge() {
			return fullDischarge;
		}
		
		@Override
		@RosettaAttribute("appropriatedCollateralValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("appropriatedCollateralValuation")
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getAppropriatedCollateralValuation() {
			return appropriatedCollateralValuation;
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getOrCreateAppropriatedCollateralValuation() {
			AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder result;
			if (appropriatedCollateralValuation!=null) {
				result = appropriatedCollateralValuation;
			}
			else {
				result = appropriatedCollateralValuation = AppropriatedCollateralValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("processAgent")
		public ProcessAgent.ProcessAgentBuilder getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent() {
			ProcessAgent.ProcessAgentBuilder result;
			if (processAgent!=null) {
				result = processAgent;
			}
			else {
				result = processAgent = ProcessAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("jurisdictionRelatedTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("jurisdictionRelatedTerms")
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms() {
			return jurisdictionRelatedTerms;
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms() {
			JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder result;
			if (jurisdictionRelatedTerms!=null) {
				result = jurisdictionRelatedTerms;
			}
			else {
				result = jurisdictionRelatedTerms = JurisdictionRelatedTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalAmendments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalAmendments")
		public String getAdditionalAmendments() {
			return additionalAmendments;
		}
		
		@Override
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalBespokeTerms")
		public String getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		@RosettaAttribute("executionTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionTerms")
		public ExecutionTerms.ExecutionTermsBuilder getExecutionTerms() {
			return executionTerms;
		}
		
		@Override
		public ExecutionTerms.ExecutionTermsBuilder getOrCreateExecutionTerms() {
			ExecutionTerms.ExecutionTermsBuilder result;
			if (executionTerms!=null) {
				result = executionTerms;
			}
			else {
				result = executionTerms = ExecutionTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("pledgedAccount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pledgedAccount")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setPledgedAccount(Account _pledgedAccount) {
			this.pledgedAccount = _pledgedAccount == null ? null : _pledgedAccount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("enforcementEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enforcementEvent")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setEnforcementEvent(EnforcementEvent _enforcementEvent) {
			this.enforcementEvent = _enforcementEvent == null ? null : _enforcementEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryInLieuRight")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryInLieuRight")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setDeliveryInLieuRight(Boolean _deliveryInLieuRight) {
			this.deliveryInLieuRight = _deliveryInLieuRight == null ? null : _deliveryInLieuRight;
			return this;
		}
		
		@RosettaAttribute("fullDischarge")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fullDischarge")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setFullDischarge(Boolean _fullDischarge) {
			this.fullDischarge = _fullDischarge == null ? null : _fullDischarge;
			return this;
		}
		
		@RosettaAttribute("appropriatedCollateralValuation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("appropriatedCollateralValuation")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setAppropriatedCollateralValuation(AppropriatedCollateralValuation _appropriatedCollateralValuation) {
			this.appropriatedCollateralValuation = _appropriatedCollateralValuation == null ? null : _appropriatedCollateralValuation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("processAgent")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setProcessAgent(ProcessAgent _processAgent) {
			this.processAgent = _processAgent == null ? null : _processAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("jurisdictionRelatedTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("jurisdictionRelatedTerms")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms _jurisdictionRelatedTerms) {
			this.jurisdictionRelatedTerms = _jurisdictionRelatedTerms == null ? null : _jurisdictionRelatedTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalAmendments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalAmendments")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setAdditionalAmendments(String _additionalAmendments) {
			this.additionalAmendments = _additionalAmendments == null ? null : _additionalAmendments;
			return this;
		}
		
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalBespokeTerms")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setAdditionalBespokeTerms(String _additionalBespokeTerms) {
			this.additionalBespokeTerms = _additionalBespokeTerms == null ? null : _additionalBespokeTerms;
			return this;
		}
		
		@RosettaAttribute("executionTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionTerms")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder setExecutionTerms(ExecutionTerms _executionTerms) {
			this.executionTerms = _executionTerms == null ? null : _executionTerms.toBuilder();
			return this;
		}
		
		@Override
		public SecurityAgreementElections build() {
			return new SecurityAgreementElections.SecurityAgreementElectionsImpl(this);
		}
		
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder prune() {
			if (pledgedAccount!=null && !pledgedAccount.prune().hasData()) pledgedAccount = null;
			if (enforcementEvent!=null && !enforcementEvent.prune().hasData()) enforcementEvent = null;
			if (appropriatedCollateralValuation!=null && !appropriatedCollateralValuation.prune().hasData()) appropriatedCollateralValuation = null;
			if (processAgent!=null && !processAgent.prune().hasData()) processAgent = null;
			if (jurisdictionRelatedTerms!=null && !jurisdictionRelatedTerms.prune().hasData()) jurisdictionRelatedTerms = null;
			if (executionTerms!=null && !executionTerms.prune().hasData()) executionTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPledgedAccount()!=null && getPledgedAccount().hasData()) return true;
			if (getEnforcementEvent()!=null && getEnforcementEvent().hasData()) return true;
			if (getDeliveryInLieuRight()!=null) return true;
			if (getFullDischarge()!=null) return true;
			if (getAppropriatedCollateralValuation()!=null && getAppropriatedCollateralValuation().hasData()) return true;
			if (getProcessAgent()!=null && getProcessAgent().hasData()) return true;
			if (getJurisdictionRelatedTerms()!=null && getJurisdictionRelatedTerms().hasData()) return true;
			if (getAdditionalAmendments()!=null) return true;
			if (getAdditionalBespokeTerms()!=null) return true;
			if (getExecutionTerms()!=null && getExecutionTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityAgreementElections.SecurityAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityAgreementElections.SecurityAgreementElectionsBuilder o = (SecurityAgreementElections.SecurityAgreementElectionsBuilder) other;
			
			merger.mergeRosetta(getPledgedAccount(), o.getPledgedAccount(), this::setPledgedAccount);
			merger.mergeRosetta(getEnforcementEvent(), o.getEnforcementEvent(), this::setEnforcementEvent);
			merger.mergeRosetta(getAppropriatedCollateralValuation(), o.getAppropriatedCollateralValuation(), this::setAppropriatedCollateralValuation);
			merger.mergeRosetta(getProcessAgent(), o.getProcessAgent(), this::setProcessAgent);
			merger.mergeRosetta(getJurisdictionRelatedTerms(), o.getJurisdictionRelatedTerms(), this::setJurisdictionRelatedTerms);
			merger.mergeRosetta(getExecutionTerms(), o.getExecutionTerms(), this::setExecutionTerms);
			
			merger.mergeBasic(getDeliveryInLieuRight(), o.getDeliveryInLieuRight(), this::setDeliveryInLieuRight);
			merger.mergeBasic(getFullDischarge(), o.getFullDischarge(), this::setFullDischarge);
			merger.mergeBasic(getAdditionalAmendments(), o.getAdditionalAmendments(), this::setAdditionalAmendments);
			merger.mergeBasic(getAdditionalBespokeTerms(), o.getAdditionalBespokeTerms(), this::setAdditionalBespokeTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(pledgedAccount, _that.getPledgedAccount())) return false;
			if (!Objects.equals(enforcementEvent, _that.getEnforcementEvent())) return false;
			if (!Objects.equals(deliveryInLieuRight, _that.getDeliveryInLieuRight())) return false;
			if (!Objects.equals(fullDischarge, _that.getFullDischarge())) return false;
			if (!Objects.equals(appropriatedCollateralValuation, _that.getAppropriatedCollateralValuation())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(executionTerms, _that.getExecutionTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pledgedAccount != null ? pledgedAccount.hashCode() : 0);
			_result = 31 * _result + (enforcementEvent != null ? enforcementEvent.hashCode() : 0);
			_result = 31 * _result + (deliveryInLieuRight != null ? deliveryInLieuRight.hashCode() : 0);
			_result = 31 * _result + (fullDischarge != null ? fullDischarge.hashCode() : 0);
			_result = 31 * _result + (appropriatedCollateralValuation != null ? appropriatedCollateralValuation.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (executionTerms != null ? executionTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityAgreementElectionsBuilder {" +
				"pledgedAccount=" + this.pledgedAccount + ", " +
				"enforcementEvent=" + this.enforcementEvent + ", " +
				"deliveryInLieuRight=" + this.deliveryInLieuRight + ", " +
				"fullDischarge=" + this.fullDischarge + ", " +
				"appropriatedCollateralValuation=" + this.appropriatedCollateralValuation + ", " +
				"processAgent=" + this.processAgent + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"executionTerms=" + this.executionTerms +
			'}';
		}
	}
}
