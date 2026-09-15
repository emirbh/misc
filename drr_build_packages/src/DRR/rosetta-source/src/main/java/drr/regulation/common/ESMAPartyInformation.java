package drr.regulation.common;

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
import drr.regulation.common.meta.ESMAPartyInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Enriched party information required for reporting a transaction under ESMA EMIR.
 * @version 7.7.0
 */
@RosettaDataType(value="ESMAPartyInformation", builder=ESMAPartyInformation.ESMAPartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ESMAPartyInformation", model="drr", builder=ESMAPartyInformation.ESMAPartyInformationBuilderImpl.class, version="7.7.0")
public interface ESMAPartyInformation extends RosettaModelObject {

	ESMAPartyInformationMeta metaData = new ESMAPartyInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the nature of the counterparty.
	 */
	NatureOfPartyEnum getNatureOfParty();
	/**
	 * Specifies the corporate sector of the counterparty.
	 */
	CorporateSector getCorporateSector();
	/**
	 * Information whether the counterparty is above the clearing threshold referred to in Article 4(a)(3) or 10(3) of Regulation (EU) No 648/2012 at the moment when the transaction was concluded.
	 */
	Boolean getExceedsClearingThreshold();
	/**
	 * Directly linked to commercial activity or treasury financing. Information on whether the contract is objectively measurable as directly linked to the counterparty 1&#39;s commercial or treasury financing activity, as referred to in Article 10(3) of Regulation (EU) No 648/2012.
	 */
	Boolean getDirectlyLinkedActivity();

	/*********************** Build Methods  ***********************/
	ESMAPartyInformation build();
	
	ESMAPartyInformation.ESMAPartyInformationBuilder toBuilder();
	
	static ESMAPartyInformation.ESMAPartyInformationBuilder builder() {
		return new ESMAPartyInformation.ESMAPartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ESMAPartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ESMAPartyInformation> getType() {
		return ESMAPartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("natureOfParty"), NatureOfPartyEnum.class, getNatureOfParty(), this);
		processRosetta(path.newSubPath("corporateSector"), processor, CorporateSector.class, getCorporateSector());
		processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
		processor.processBasic(path.newSubPath("directlyLinkedActivity"), Boolean.class, getDirectlyLinkedActivity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ESMAPartyInformationBuilder extends ESMAPartyInformation, RosettaModelObjectBuilder {
		CorporateSector.CorporateSectorBuilder getOrCreateCorporateSector();
		@Override
		CorporateSector.CorporateSectorBuilder getCorporateSector();
		ESMAPartyInformation.ESMAPartyInformationBuilder setNatureOfParty(NatureOfPartyEnum natureOfParty);
		ESMAPartyInformation.ESMAPartyInformationBuilder setCorporateSector(CorporateSector corporateSector);
		ESMAPartyInformation.ESMAPartyInformationBuilder setExceedsClearingThreshold(Boolean exceedsClearingThreshold);
		ESMAPartyInformation.ESMAPartyInformationBuilder setDirectlyLinkedActivity(Boolean directlyLinkedActivity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("natureOfParty"), NatureOfPartyEnum.class, getNatureOfParty(), this);
			processRosetta(path.newSubPath("corporateSector"), processor, CorporateSector.CorporateSectorBuilder.class, getCorporateSector());
			processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
			processor.processBasic(path.newSubPath("directlyLinkedActivity"), Boolean.class, getDirectlyLinkedActivity(), this);
		}
		

		ESMAPartyInformation.ESMAPartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of ESMAPartyInformation  ***********************/
	class ESMAPartyInformationImpl implements ESMAPartyInformation {
		private final NatureOfPartyEnum natureOfParty;
		private final CorporateSector corporateSector;
		private final Boolean exceedsClearingThreshold;
		private final Boolean directlyLinkedActivity;
		
		protected ESMAPartyInformationImpl(ESMAPartyInformation.ESMAPartyInformationBuilder builder) {
			this.natureOfParty = builder.getNatureOfParty();
			this.corporateSector = ofNullable(builder.getCorporateSector()).map(f->f.build()).orElse(null);
			this.exceedsClearingThreshold = builder.getExceedsClearingThreshold();
			this.directlyLinkedActivity = builder.getDirectlyLinkedActivity();
		}
		
		@Override
		@RosettaAttribute("natureOfParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("natureOfParty")
		public NatureOfPartyEnum getNatureOfParty() {
			return natureOfParty;
		}
		
		@Override
		@RosettaAttribute("corporateSector")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateSector")
		public CorporateSector getCorporateSector() {
			return corporateSector;
		}
		
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exceedsClearingThreshold")
		public Boolean getExceedsClearingThreshold() {
			return exceedsClearingThreshold;
		}
		
		@Override
		@RosettaAttribute("directlyLinkedActivity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("directlyLinkedActivity")
		public Boolean getDirectlyLinkedActivity() {
			return directlyLinkedActivity;
		}
		
		@Override
		public ESMAPartyInformation build() {
			return this;
		}
		
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder toBuilder() {
			ESMAPartyInformation.ESMAPartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ESMAPartyInformation.ESMAPartyInformationBuilder builder) {
			ofNullable(getNatureOfParty()).ifPresent(builder::setNatureOfParty);
			ofNullable(getCorporateSector()).ifPresent(builder::setCorporateSector);
			ofNullable(getExceedsClearingThreshold()).ifPresent(builder::setExceedsClearingThreshold);
			ofNullable(getDirectlyLinkedActivity()).ifPresent(builder::setDirectlyLinkedActivity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(natureOfParty, _that.getNatureOfParty())) return false;
			if (!Objects.equals(corporateSector, _that.getCorporateSector())) return false;
			if (!Objects.equals(exceedsClearingThreshold, _that.getExceedsClearingThreshold())) return false;
			if (!Objects.equals(directlyLinkedActivity, _that.getDirectlyLinkedActivity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (natureOfParty != null ? natureOfParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (corporateSector != null ? corporateSector.hashCode() : 0);
			_result = 31 * _result + (exceedsClearingThreshold != null ? exceedsClearingThreshold.hashCode() : 0);
			_result = 31 * _result + (directlyLinkedActivity != null ? directlyLinkedActivity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAPartyInformation {" +
				"natureOfParty=" + this.natureOfParty + ", " +
				"corporateSector=" + this.corporateSector + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"directlyLinkedActivity=" + this.directlyLinkedActivity +
			'}';
		}
	}

	/*********************** Builder Implementation of ESMAPartyInformation  ***********************/
	class ESMAPartyInformationBuilderImpl implements ESMAPartyInformation.ESMAPartyInformationBuilder {
	
		protected NatureOfPartyEnum natureOfParty;
		protected CorporateSector.CorporateSectorBuilder corporateSector;
		protected Boolean exceedsClearingThreshold;
		protected Boolean directlyLinkedActivity;
		
		@Override
		@RosettaAttribute("natureOfParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("natureOfParty")
		public NatureOfPartyEnum getNatureOfParty() {
			return natureOfParty;
		}
		
		@Override
		@RosettaAttribute("corporateSector")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateSector")
		public CorporateSector.CorporateSectorBuilder getCorporateSector() {
			return corporateSector;
		}
		
		@Override
		public CorporateSector.CorporateSectorBuilder getOrCreateCorporateSector() {
			CorporateSector.CorporateSectorBuilder result;
			if (corporateSector!=null) {
				result = corporateSector;
			}
			else {
				result = corporateSector = CorporateSector.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exceedsClearingThreshold")
		public Boolean getExceedsClearingThreshold() {
			return exceedsClearingThreshold;
		}
		
		@Override
		@RosettaAttribute("directlyLinkedActivity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("directlyLinkedActivity")
		public Boolean getDirectlyLinkedActivity() {
			return directlyLinkedActivity;
		}
		
		@RosettaAttribute("natureOfParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("natureOfParty")
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder setNatureOfParty(NatureOfPartyEnum _natureOfParty) {
			this.natureOfParty = _natureOfParty == null ? null : _natureOfParty;
			return this;
		}
		
		@RosettaAttribute("corporateSector")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("corporateSector")
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder setCorporateSector(CorporateSector _corporateSector) {
			this.corporateSector = _corporateSector == null ? null : _corporateSector.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exceedsClearingThreshold")
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder setExceedsClearingThreshold(Boolean _exceedsClearingThreshold) {
			this.exceedsClearingThreshold = _exceedsClearingThreshold == null ? null : _exceedsClearingThreshold;
			return this;
		}
		
		@RosettaAttribute("directlyLinkedActivity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("directlyLinkedActivity")
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder setDirectlyLinkedActivity(Boolean _directlyLinkedActivity) {
			this.directlyLinkedActivity = _directlyLinkedActivity == null ? null : _directlyLinkedActivity;
			return this;
		}
		
		@Override
		public ESMAPartyInformation build() {
			return new ESMAPartyInformation.ESMAPartyInformationImpl(this);
		}
		
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder prune() {
			if (corporateSector!=null && !corporateSector.prune().hasData()) corporateSector = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNatureOfParty()!=null) return true;
			if (getCorporateSector()!=null && getCorporateSector().hasData()) return true;
			if (getExceedsClearingThreshold()!=null) return true;
			if (getDirectlyLinkedActivity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAPartyInformation.ESMAPartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ESMAPartyInformation.ESMAPartyInformationBuilder o = (ESMAPartyInformation.ESMAPartyInformationBuilder) other;
			
			merger.mergeRosetta(getCorporateSector(), o.getCorporateSector(), this::setCorporateSector);
			
			merger.mergeBasic(getNatureOfParty(), o.getNatureOfParty(), this::setNatureOfParty);
			merger.mergeBasic(getExceedsClearingThreshold(), o.getExceedsClearingThreshold(), this::setExceedsClearingThreshold);
			merger.mergeBasic(getDirectlyLinkedActivity(), o.getDirectlyLinkedActivity(), this::setDirectlyLinkedActivity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAPartyInformation _that = getType().cast(o);
		
			if (!Objects.equals(natureOfParty, _that.getNatureOfParty())) return false;
			if (!Objects.equals(corporateSector, _that.getCorporateSector())) return false;
			if (!Objects.equals(exceedsClearingThreshold, _that.getExceedsClearingThreshold())) return false;
			if (!Objects.equals(directlyLinkedActivity, _that.getDirectlyLinkedActivity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (natureOfParty != null ? natureOfParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (corporateSector != null ? corporateSector.hashCode() : 0);
			_result = 31 * _result + (exceedsClearingThreshold != null ? exceedsClearingThreshold.hashCode() : 0);
			_result = 31 * _result + (directlyLinkedActivity != null ? directlyLinkedActivity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAPartyInformationBuilder {" +
				"natureOfParty=" + this.natureOfParty + ", " +
				"corporateSector=" + this.corporateSector + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"directlyLinkedActivity=" + this.directlyLinkedActivity +
			'}';
		}
	}
}
