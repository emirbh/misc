package cdm.legaldocumentation.csa;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.CalculationDateLocationElectionMeta;
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
 * A class to specify each of the party elections with respect to the Calculation Date Location.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(i)" * name "Calculation Date Location"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(e)(i)" * name "Calculation Date Location"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(i)" * name "Calculation Date Location"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CalculationDateLocationElection", builder=CalculationDateLocationElection.CalculationDateLocationElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CalculationDateLocationElection", model="cdm", builder=CalculationDateLocationElection.CalculationDateLocationElectionBuilderImpl.class, version="6.23.0")
public interface CalculationDateLocationElection extends RosettaModelObject {

	CalculationDateLocationElectionMeta metaData = new CalculationDateLocationElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The Calculation Date Location when specified as a business center which corresponds to the FpML list of business centers or can be mapped to it.
	 */
	FieldWithMetaBusinessCenterEnum getBusinessCenter();
	/**
	 * The Calculation Date Location when specified a location which doesn&#39;t correspond to the FpML list of business centers or cannot be mapped to it.
	 */
	String getCustomLocation();

	/*********************** Build Methods  ***********************/
	CalculationDateLocationElection build();
	
	CalculationDateLocationElection.CalculationDateLocationElectionBuilder toBuilder();
	
	static CalculationDateLocationElection.CalculationDateLocationElectionBuilder builder() {
		return new CalculationDateLocationElection.CalculationDateLocationElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationDateLocationElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationDateLocationElection> getType() {
		return CalculationDateLocationElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnum.class, getBusinessCenter());
		processor.processBasic(path.newSubPath("customLocation"), String.class, getCustomLocation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationDateLocationElectionBuilder extends CalculationDateLocationElection, RosettaModelObjectBuilder {
		FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter();
		@Override
		FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder getBusinessCenter();
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder setParty(CounterpartyRoleEnum party);
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum businessCenter);
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder setBusinessCenterValue(BusinessCenterEnum businessCenter);
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder setCustomLocation(String customLocation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processRosetta(path.newSubPath("businessCenter"), processor, FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder.class, getBusinessCenter());
			processor.processBasic(path.newSubPath("customLocation"), String.class, getCustomLocation(), this);
		}
		

		CalculationDateLocationElection.CalculationDateLocationElectionBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationDateLocationElection  ***********************/
	class CalculationDateLocationElectionImpl implements CalculationDateLocationElection {
		private final CounterpartyRoleEnum party;
		private final FieldWithMetaBusinessCenterEnum businessCenter;
		private final String customLocation;
		
		protected CalculationDateLocationElectionImpl(CalculationDateLocationElection.CalculationDateLocationElectionBuilder builder) {
			this.party = builder.getParty();
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
			this.customLocation = builder.getCustomLocation();
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
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenter")
		public FieldWithMetaBusinessCenterEnum getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		@RosettaAttribute("customLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customLocation")
		public String getCustomLocation() {
			return customLocation;
		}
		
		@Override
		public CalculationDateLocationElection build() {
			return this;
		}
		
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder toBuilder() {
			CalculationDateLocationElection.CalculationDateLocationElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationDateLocationElection.CalculationDateLocationElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getCustomLocation()).ifPresent(builder::setCustomLocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationDateLocationElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(customLocation, _that.getCustomLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (customLocation != null ? customLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationDateLocationElection {" +
				"party=" + this.party + ", " +
				"businessCenter=" + this.businessCenter + ", " +
				"customLocation=" + this.customLocation +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationDateLocationElection  ***********************/
	class CalculationDateLocationElectionBuilderImpl implements CalculationDateLocationElection.CalculationDateLocationElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder businessCenter;
		protected String customLocation;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenter")
		public FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder getOrCreateBusinessCenter() {
			FieldWithMetaBusinessCenterEnum.FieldWithMetaBusinessCenterEnumBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = FieldWithMetaBusinessCenterEnum.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("customLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customLocation")
		public String getCustomLocation() {
			return customLocation;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenter")
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder setBusinessCenter(FieldWithMetaBusinessCenterEnum _businessCenter) {
			this.businessCenter = _businessCenter == null ? null : _businessCenter.toBuilder();
			return this;
		}
		
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder setBusinessCenterValue(BusinessCenterEnum _businessCenter) {
			this.getOrCreateBusinessCenter().setValue(_businessCenter);
			return this;
		}
		
		@RosettaAttribute("customLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customLocation")
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder setCustomLocation(String _customLocation) {
			this.customLocation = _customLocation == null ? null : _customLocation;
			return this;
		}
		
		@Override
		public CalculationDateLocationElection build() {
			return new CalculationDateLocationElection.CalculationDateLocationElectionImpl(this);
		}
		
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder prune() {
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getBusinessCenter()!=null) return true;
			if (getCustomLocation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationDateLocationElection.CalculationDateLocationElectionBuilder o = (CalculationDateLocationElection.CalculationDateLocationElectionBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getCustomLocation(), o.getCustomLocation(), this::setCustomLocation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationDateLocationElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(customLocation, _that.getCustomLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (customLocation != null ? customLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationDateLocationElectionBuilder {" +
				"party=" + this.party + ", " +
				"businessCenter=" + this.businessCenter + ", " +
				"customLocation=" + this.customLocation +
			'}';
		}
	}
}
