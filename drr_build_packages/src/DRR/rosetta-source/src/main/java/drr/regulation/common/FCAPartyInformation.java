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
import drr.regulation.common.meta.FCAPartyInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Enriched party information required for reporting a transaction under FCA UK EMIR.
 * @version 7.7.0
 */
@RosettaDataType(value="FCAPartyInformation", builder=FCAPartyInformation.FCAPartyInformationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="FCAPartyInformation", model="drr", builder=FCAPartyInformation.FCAPartyInformationBuilderImpl.class, version="7.7.0")
public interface FCAPartyInformation extends RosettaModelObject {

	FCAPartyInformationMeta metaData = new FCAPartyInformationMeta();

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
	FCAPartyInformation build();
	
	FCAPartyInformation.FCAPartyInformationBuilder toBuilder();
	
	static FCAPartyInformation.FCAPartyInformationBuilder builder() {
		return new FCAPartyInformation.FCAPartyInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FCAPartyInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FCAPartyInformation> getType() {
		return FCAPartyInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("natureOfParty"), NatureOfPartyEnum.class, getNatureOfParty(), this);
		processRosetta(path.newSubPath("corporateSector"), processor, CorporateSector.class, getCorporateSector());
		processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
		processor.processBasic(path.newSubPath("directlyLinkedActivity"), Boolean.class, getDirectlyLinkedActivity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FCAPartyInformationBuilder extends FCAPartyInformation, RosettaModelObjectBuilder {
		CorporateSector.CorporateSectorBuilder getOrCreateCorporateSector();
		@Override
		CorporateSector.CorporateSectorBuilder getCorporateSector();
		FCAPartyInformation.FCAPartyInformationBuilder setNatureOfParty(NatureOfPartyEnum natureOfParty);
		FCAPartyInformation.FCAPartyInformationBuilder setCorporateSector(CorporateSector corporateSector);
		FCAPartyInformation.FCAPartyInformationBuilder setExceedsClearingThreshold(Boolean exceedsClearingThreshold);
		FCAPartyInformation.FCAPartyInformationBuilder setDirectlyLinkedActivity(Boolean directlyLinkedActivity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("natureOfParty"), NatureOfPartyEnum.class, getNatureOfParty(), this);
			processRosetta(path.newSubPath("corporateSector"), processor, CorporateSector.CorporateSectorBuilder.class, getCorporateSector());
			processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
			processor.processBasic(path.newSubPath("directlyLinkedActivity"), Boolean.class, getDirectlyLinkedActivity(), this);
		}
		

		FCAPartyInformation.FCAPartyInformationBuilder prune();
	}

	/*********************** Immutable Implementation of FCAPartyInformation  ***********************/
	class FCAPartyInformationImpl implements FCAPartyInformation {
		private final NatureOfPartyEnum natureOfParty;
		private final CorporateSector corporateSector;
		private final Boolean exceedsClearingThreshold;
		private final Boolean directlyLinkedActivity;
		
		protected FCAPartyInformationImpl(FCAPartyInformation.FCAPartyInformationBuilder builder) {
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
		public FCAPartyInformation build() {
			return this;
		}
		
		@Override
		public FCAPartyInformation.FCAPartyInformationBuilder toBuilder() {
			FCAPartyInformation.FCAPartyInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FCAPartyInformation.FCAPartyInformationBuilder builder) {
			ofNullable(getNatureOfParty()).ifPresent(builder::setNatureOfParty);
			ofNullable(getCorporateSector()).ifPresent(builder::setCorporateSector);
			ofNullable(getExceedsClearingThreshold()).ifPresent(builder::setExceedsClearingThreshold);
			ofNullable(getDirectlyLinkedActivity()).ifPresent(builder::setDirectlyLinkedActivity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FCAPartyInformation _that = getType().cast(o);
		
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
			return "FCAPartyInformation {" +
				"natureOfParty=" + this.natureOfParty + ", " +
				"corporateSector=" + this.corporateSector + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"directlyLinkedActivity=" + this.directlyLinkedActivity +
			'}';
		}
	}

	/*********************** Builder Implementation of FCAPartyInformation  ***********************/
	class FCAPartyInformationBuilderImpl implements FCAPartyInformation.FCAPartyInformationBuilder {
	
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
		public FCAPartyInformation.FCAPartyInformationBuilder setNatureOfParty(NatureOfPartyEnum _natureOfParty) {
			this.natureOfParty = _natureOfParty == null ? null : _natureOfParty;
			return this;
		}
		
		@RosettaAttribute("corporateSector")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("corporateSector")
		@Override
		public FCAPartyInformation.FCAPartyInformationBuilder setCorporateSector(CorporateSector _corporateSector) {
			this.corporateSector = _corporateSector == null ? null : _corporateSector.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exceedsClearingThreshold")
		@Override
		public FCAPartyInformation.FCAPartyInformationBuilder setExceedsClearingThreshold(Boolean _exceedsClearingThreshold) {
			this.exceedsClearingThreshold = _exceedsClearingThreshold == null ? null : _exceedsClearingThreshold;
			return this;
		}
		
		@RosettaAttribute("directlyLinkedActivity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("directlyLinkedActivity")
		@Override
		public FCAPartyInformation.FCAPartyInformationBuilder setDirectlyLinkedActivity(Boolean _directlyLinkedActivity) {
			this.directlyLinkedActivity = _directlyLinkedActivity == null ? null : _directlyLinkedActivity;
			return this;
		}
		
		@Override
		public FCAPartyInformation build() {
			return new FCAPartyInformation.FCAPartyInformationImpl(this);
		}
		
		@Override
		public FCAPartyInformation.FCAPartyInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAPartyInformation.FCAPartyInformationBuilder prune() {
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
		public FCAPartyInformation.FCAPartyInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FCAPartyInformation.FCAPartyInformationBuilder o = (FCAPartyInformation.FCAPartyInformationBuilder) other;
			
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
		
			FCAPartyInformation _that = getType().cast(o);
		
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
			return "FCAPartyInformationBuilder {" +
				"natureOfParty=" + this.natureOfParty + ", " +
				"corporateSector=" + this.corporateSector + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"directlyLinkedActivity=" + this.directlyLinkedActivity +
			'}';
		}
	}
}
