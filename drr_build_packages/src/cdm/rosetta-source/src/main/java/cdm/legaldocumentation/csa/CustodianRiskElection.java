package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.CustodianRiskElectionMeta;
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
 * A class to specify the Custodian Risk.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(ii)" * name "Custodian (IM) Risk"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2018 ISDA 2018 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(ii)" * name "Custodian (IM) Risk"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(m)(ii)" * name "Collateral Manager Risk"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(ii)" * name "Custodian (IM) Risk"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CustodianRiskElection", builder=CustodianRiskElection.CustodianRiskElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CustodianRiskElection", model="cdm", builder=CustodianRiskElection.CustodianRiskElectionBuilderImpl.class, version="6.23.0")
public interface CustodianRiskElection extends RosettaModelObject {

	CustodianRiskElectionMeta metaData = new CustodianRiskElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The qualification as to whether the risk is deemed as Specified.
	 */
	Boolean getIsSpecified();
	/**
	 * The Custodian Risk or Collateral Manager Risk qualification.
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
	 * paragraph "13 General Principles" * clause "(n)(ii)" * name "Custodian (IM) Risk"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Deed CSD_IM_English_2018 ISDA 2018 English Law Credit Support Deed for Initial Margin  
	 * paragraph "13 General Principles" * clause "(n)(ii)" * name "Custodian (IM) Risk"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(m)(ii)" * name "Collateral Manager Risk"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(n)(ii)" * name "Custodian (IM) Risk"
	 *
	 * Provision 
	 *
	 */
	String getQualification();

	/*********************** Build Methods  ***********************/
	CustodianRiskElection build();
	
	CustodianRiskElection.CustodianRiskElectionBuilder toBuilder();
	
	static CustodianRiskElection.CustodianRiskElectionBuilder builder() {
		return new CustodianRiskElection.CustodianRiskElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustodianRiskElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustodianRiskElection> getType() {
		return CustodianRiskElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
		processor.processBasic(path.newSubPath("qualification"), String.class, getQualification(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustodianRiskElectionBuilder extends CustodianRiskElection, RosettaModelObjectBuilder {
		CustodianRiskElection.CustodianRiskElectionBuilder setParty(CounterpartyRoleEnum party);
		CustodianRiskElection.CustodianRiskElectionBuilder setIsSpecified(Boolean isSpecified);
		CustodianRiskElection.CustodianRiskElectionBuilder setQualification(String qualification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
			processor.processBasic(path.newSubPath("qualification"), String.class, getQualification(), this);
		}
		

		CustodianRiskElection.CustodianRiskElectionBuilder prune();
	}

	/*********************** Immutable Implementation of CustodianRiskElection  ***********************/
	class CustodianRiskElectionImpl implements CustodianRiskElection {
		private final CounterpartyRoleEnum party;
		private final Boolean isSpecified;
		private final String qualification;
		
		protected CustodianRiskElectionImpl(CustodianRiskElection.CustodianRiskElectionBuilder builder) {
			this.party = builder.getParty();
			this.isSpecified = builder.getIsSpecified();
			this.qualification = builder.getQualification();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isSpecified")
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		@RosettaAttribute("qualification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qualification")
		public String getQualification() {
			return qualification;
		}
		
		@Override
		public CustodianRiskElection build() {
			return this;
		}
		
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder toBuilder() {
			CustodianRiskElection.CustodianRiskElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianRiskElection.CustodianRiskElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getIsSpecified()).ifPresent(builder::setIsSpecified);
			ofNullable(getQualification()).ifPresent(builder::setQualification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianRiskElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(qualification, _that.getQualification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (qualification != null ? qualification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianRiskElection {" +
				"party=" + this.party + ", " +
				"isSpecified=" + this.isSpecified + ", " +
				"qualification=" + this.qualification +
			'}';
		}
	}

	/*********************** Builder Implementation of CustodianRiskElection  ***********************/
	class CustodianRiskElectionBuilderImpl implements CustodianRiskElection.CustodianRiskElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected Boolean isSpecified;
		protected String qualification;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isSpecified")
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		@RosettaAttribute("qualification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qualification")
		public String getQualification() {
			return qualification;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("party")
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("isSpecified")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isSpecified")
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder setIsSpecified(Boolean _isSpecified) {
			this.isSpecified = _isSpecified == null ? null : _isSpecified;
			return this;
		}
		
		@RosettaAttribute("qualification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("qualification")
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder setQualification(String _qualification) {
			this.qualification = _qualification == null ? null : _qualification;
			return this;
		}
		
		@Override
		public CustodianRiskElection build() {
			return new CustodianRiskElection.CustodianRiskElectionImpl(this);
		}
		
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getIsSpecified()!=null) return true;
			if (getQualification()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianRiskElection.CustodianRiskElectionBuilder o = (CustodianRiskElection.CustodianRiskElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getIsSpecified(), o.getIsSpecified(), this::setIsSpecified);
			merger.mergeBasic(getQualification(), o.getQualification(), this::setQualification);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianRiskElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			if (!Objects.equals(qualification, _that.getQualification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			_result = 31 * _result + (qualification != null ? qualification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianRiskElectionBuilder {" +
				"party=" + this.party + ", " +
				"isSpecified=" + this.isSpecified + ", " +
				"qualification=" + this.qualification +
			'}';
		}
	}
}
