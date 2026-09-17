package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.HoldingAndUsingPostedCollateralElectionMeta;
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
 * A class to specify the parties&#39; elections related to the holding and using of posted collateral.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13" * clause " (h)" * name "Holding and Using Posted Collateral (VM)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="HoldingAndUsingPostedCollateralElection", builder=HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="HoldingAndUsingPostedCollateralElection", model="cdm", builder=HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilderImpl.class, version="6.23.0")
public interface HoldingAndUsingPostedCollateralElection extends RosettaModelObject {

	HoldingAndUsingPostedCollateralElectionMeta metaData = new HoldingAndUsingPostedCollateralElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The specification of the conditions under which a party and its custodian(s) are entitled to hold posted collateral.
	 */
	EligibilityToHoldCollateral getEligibilityToHoldCollateral();
	/**
	 * Specifies whether the party to the agreement has the right to rehypothecate the collateral held (True).
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13" * clause "(h)(ii)" * name "Use of Posted Collateral (VM)"
	 *
	 * Provision 
	 *
	 */
	Boolean getUseOfPostedCollateral();

	/*********************** Build Methods  ***********************/
	HoldingAndUsingPostedCollateralElection build();
	
	HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder toBuilder();
	
	static HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder builder() {
		return new HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends HoldingAndUsingPostedCollateralElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends HoldingAndUsingPostedCollateralElection> getType() {
		return HoldingAndUsingPostedCollateralElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processRosetta(path.newSubPath("eligibilityToHoldCollateral"), processor, EligibilityToHoldCollateral.class, getEligibilityToHoldCollateral());
		processor.processBasic(path.newSubPath("useOfPostedCollateral"), Boolean.class, getUseOfPostedCollateral(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface HoldingAndUsingPostedCollateralElectionBuilder extends HoldingAndUsingPostedCollateralElection, RosettaModelObjectBuilder {
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder getOrCreateEligibilityToHoldCollateral();
		@Override
		EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder getEligibilityToHoldCollateral();
		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setParty(CounterpartyRoleEnum party);
		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setEligibilityToHoldCollateral(EligibilityToHoldCollateral eligibilityToHoldCollateral);
		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setUseOfPostedCollateral(Boolean useOfPostedCollateral);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processRosetta(path.newSubPath("eligibilityToHoldCollateral"), processor, EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder.class, getEligibilityToHoldCollateral());
			processor.processBasic(path.newSubPath("useOfPostedCollateral"), Boolean.class, getUseOfPostedCollateral(), this);
		}
		

		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder prune();
	}

	/*********************** Immutable Implementation of HoldingAndUsingPostedCollateralElection  ***********************/
	class HoldingAndUsingPostedCollateralElectionImpl implements HoldingAndUsingPostedCollateralElection {
		private final CounterpartyRoleEnum party;
		private final EligibilityToHoldCollateral eligibilityToHoldCollateral;
		private final Boolean useOfPostedCollateral;
		
		protected HoldingAndUsingPostedCollateralElectionImpl(HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder builder) {
			this.party = builder.getParty();
			this.eligibilityToHoldCollateral = ofNullable(builder.getEligibilityToHoldCollateral()).map(f->f.build()).orElse(null);
			this.useOfPostedCollateral = builder.getUseOfPostedCollateral();
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
		@RosettaAttribute("eligibilityToHoldCollateral")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eligibilityToHoldCollateral")
		public EligibilityToHoldCollateral getEligibilityToHoldCollateral() {
			return eligibilityToHoldCollateral;
		}
		
		@Override
		@RosettaAttribute("useOfPostedCollateral")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("useOfPostedCollateral")
		public Boolean getUseOfPostedCollateral() {
			return useOfPostedCollateral;
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection build() {
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder toBuilder() {
			HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getEligibilityToHoldCollateral()).ifPresent(builder::setEligibilityToHoldCollateral);
			ofNullable(getUseOfPostedCollateral()).ifPresent(builder::setUseOfPostedCollateral);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HoldingAndUsingPostedCollateralElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(eligibilityToHoldCollateral, _that.getEligibilityToHoldCollateral())) return false;
			if (!Objects.equals(useOfPostedCollateral, _that.getUseOfPostedCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eligibilityToHoldCollateral != null ? eligibilityToHoldCollateral.hashCode() : 0);
			_result = 31 * _result + (useOfPostedCollateral != null ? useOfPostedCollateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HoldingAndUsingPostedCollateralElection {" +
				"party=" + this.party + ", " +
				"eligibilityToHoldCollateral=" + this.eligibilityToHoldCollateral + ", " +
				"useOfPostedCollateral=" + this.useOfPostedCollateral +
			'}';
		}
	}

	/*********************** Builder Implementation of HoldingAndUsingPostedCollateralElection  ***********************/
	class HoldingAndUsingPostedCollateralElectionBuilderImpl implements HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder eligibilityToHoldCollateral;
		protected Boolean useOfPostedCollateral;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("eligibilityToHoldCollateral")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eligibilityToHoldCollateral")
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder getEligibilityToHoldCollateral() {
			return eligibilityToHoldCollateral;
		}
		
		@Override
		public EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder getOrCreateEligibilityToHoldCollateral() {
			EligibilityToHoldCollateral.EligibilityToHoldCollateralBuilder result;
			if (eligibilityToHoldCollateral!=null) {
				result = eligibilityToHoldCollateral;
			}
			else {
				result = eligibilityToHoldCollateral = EligibilityToHoldCollateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("useOfPostedCollateral")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("useOfPostedCollateral")
		public Boolean getUseOfPostedCollateral() {
			return useOfPostedCollateral;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("eligibilityToHoldCollateral")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eligibilityToHoldCollateral")
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setEligibilityToHoldCollateral(EligibilityToHoldCollateral _eligibilityToHoldCollateral) {
			this.eligibilityToHoldCollateral = _eligibilityToHoldCollateral == null ? null : _eligibilityToHoldCollateral.toBuilder();
			return this;
		}
		
		@RosettaAttribute("useOfPostedCollateral")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("useOfPostedCollateral")
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder setUseOfPostedCollateral(Boolean _useOfPostedCollateral) {
			this.useOfPostedCollateral = _useOfPostedCollateral == null ? null : _useOfPostedCollateral;
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection build() {
			return new HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionImpl(this);
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder prune() {
			if (eligibilityToHoldCollateral!=null && !eligibilityToHoldCollateral.prune().hasData()) eligibilityToHoldCollateral = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getEligibilityToHoldCollateral()!=null && getEligibilityToHoldCollateral().hasData()) return true;
			if (getUseOfPostedCollateral()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder o = (HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder) other;
			
			merger.mergeRosetta(getEligibilityToHoldCollateral(), o.getEligibilityToHoldCollateral(), this::setEligibilityToHoldCollateral);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getUseOfPostedCollateral(), o.getUseOfPostedCollateral(), this::setUseOfPostedCollateral);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HoldingAndUsingPostedCollateralElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(eligibilityToHoldCollateral, _that.getEligibilityToHoldCollateral())) return false;
			if (!Objects.equals(useOfPostedCollateral, _that.getUseOfPostedCollateral())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (eligibilityToHoldCollateral != null ? eligibilityToHoldCollateral.hashCode() : 0);
			_result = 31 * _result + (useOfPostedCollateral != null ? useOfPostedCollateral.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HoldingAndUsingPostedCollateralElectionBuilder {" +
				"party=" + this.party + ", " +
				"eligibilityToHoldCollateral=" + this.eligibilityToHoldCollateral + ", " +
				"useOfPostedCollateral=" + this.useOfPostedCollateral +
			'}';
		}
	}
}
