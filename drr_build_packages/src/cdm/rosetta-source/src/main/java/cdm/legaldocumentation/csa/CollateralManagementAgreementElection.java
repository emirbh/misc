package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.CollateralManagementAgreementElectionMeta;
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
 * A class to specify the Collateral Management Agreement election.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(b(i)" * name "Collateral Management Agreement"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CollateralManagementAgreementElection", builder=CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralManagementAgreementElection", model="cdm", builder=CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilderImpl.class, version="6.23.0")
public interface CollateralManagementAgreementElection extends RosettaModelObject {

	CollateralManagementAgreementElectionMeta metaData = new CollateralManagementAgreementElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The designated Collateral Management Agreement with respect to the elective party as the Obligee.
	 */
	String getCollateralManagementAgreement();

	/*********************** Build Methods  ***********************/
	CollateralManagementAgreementElection build();
	
	CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder toBuilder();
	
	static CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder builder() {
		return new CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralManagementAgreementElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralManagementAgreementElection> getType() {
		return CollateralManagementAgreementElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("collateralManagementAgreement"), String.class, getCollateralManagementAgreement(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralManagementAgreementElectionBuilder extends CollateralManagementAgreementElection, RosettaModelObjectBuilder {
		CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder setParty(CounterpartyRoleEnum party);
		CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder setCollateralManagementAgreement(String collateralManagementAgreement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("collateralManagementAgreement"), String.class, getCollateralManagementAgreement(), this);
		}
		

		CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralManagementAgreementElection  ***********************/
	class CollateralManagementAgreementElectionImpl implements CollateralManagementAgreementElection {
		private final CounterpartyRoleEnum party;
		private final String collateralManagementAgreement;
		
		protected CollateralManagementAgreementElectionImpl(CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder builder) {
			this.party = builder.getParty();
			this.collateralManagementAgreement = builder.getCollateralManagementAgreement();
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
		@RosettaAttribute("collateralManagementAgreement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralManagementAgreement")
		public String getCollateralManagementAgreement() {
			return collateralManagementAgreement;
		}
		
		@Override
		public CollateralManagementAgreementElection build() {
			return this;
		}
		
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder toBuilder() {
			CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getCollateralManagementAgreement()).ifPresent(builder::setCollateralManagementAgreement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralManagementAgreementElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(collateralManagementAgreement, _that.getCollateralManagementAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (collateralManagementAgreement != null ? collateralManagementAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralManagementAgreementElection {" +
				"party=" + this.party + ", " +
				"collateralManagementAgreement=" + this.collateralManagementAgreement +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralManagementAgreementElection  ***********************/
	class CollateralManagementAgreementElectionBuilderImpl implements CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected String collateralManagementAgreement;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("collateralManagementAgreement")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralManagementAgreement")
		public String getCollateralManagementAgreement() {
			return collateralManagementAgreement;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("collateralManagementAgreement")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collateralManagementAgreement")
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder setCollateralManagementAgreement(String _collateralManagementAgreement) {
			this.collateralManagementAgreement = _collateralManagementAgreement == null ? null : _collateralManagementAgreement;
			return this;
		}
		
		@Override
		public CollateralManagementAgreementElection build() {
			return new CollateralManagementAgreementElection.CollateralManagementAgreementElectionImpl(this);
		}
		
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getCollateralManagementAgreement()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder o = (CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getCollateralManagementAgreement(), o.getCollateralManagementAgreement(), this::setCollateralManagementAgreement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralManagementAgreementElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(collateralManagementAgreement, _that.getCollateralManagementAgreement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (collateralManagementAgreement != null ? collateralManagementAgreement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralManagementAgreementElectionBuilder {" +
				"party=" + this.party + ", " +
				"collateralManagementAgreement=" + this.collateralManagementAgreement +
			'}';
		}
	}
}
