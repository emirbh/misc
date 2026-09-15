package drr.regulation.fca.ukemir.refit.margin;

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
import drr.enrichment.common.EnrichmentData;
import drr.regulation.fca.ukemir.refit.margin.meta.FCAUKEMIRNonReportableCollateralDataMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="FCAUKEMIRNonReportableCollateralData", builder=FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilderImpl.class, version="7.7.0")
@RuneDataType(value="FCAUKEMIRNonReportableCollateralData", model="drr", builder=FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilderImpl.class, version="7.7.0")
public interface FCAUKEMIRNonReportableCollateralData extends RosettaModelObject {

	FCAUKEMIRNonReportableCollateralDataMeta metaData = new FCAUKEMIRNonReportableCollateralDataMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Populated by pre-enrichment process
	 */
	EnrichmentData getEnrichment();
	String getMic();
	String getRelationshipRecord();

	/*********************** Build Methods  ***********************/
	FCAUKEMIRNonReportableCollateralData build();
	
	FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder toBuilder();
	
	static FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder builder() {
		return new FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FCAUKEMIRNonReportableCollateralData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FCAUKEMIRNonReportableCollateralData> getType() {
		return FCAUKEMIRNonReportableCollateralData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.class, getEnrichment());
		processor.processBasic(path.newSubPath("mic"), String.class, getMic(), this);
		processor.processBasic(path.newSubPath("relationshipRecord"), String.class, getRelationshipRecord(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FCAUKEMIRNonReportableCollateralDataBuilder extends FCAUKEMIRNonReportableCollateralData, RosettaModelObjectBuilder {
		EnrichmentData.EnrichmentDataBuilder getOrCreateEnrichment();
		@Override
		EnrichmentData.EnrichmentDataBuilder getEnrichment();
		FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder setEnrichment(EnrichmentData enrichment);
		FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder setMic(String mic);
		FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder setRelationshipRecord(String relationshipRecord);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.EnrichmentDataBuilder.class, getEnrichment());
			processor.processBasic(path.newSubPath("mic"), String.class, getMic(), this);
			processor.processBasic(path.newSubPath("relationshipRecord"), String.class, getRelationshipRecord(), this);
		}
		

		FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder prune();
	}

	/*********************** Immutable Implementation of FCAUKEMIRNonReportableCollateralData  ***********************/
	class FCAUKEMIRNonReportableCollateralDataImpl implements FCAUKEMIRNonReportableCollateralData {
		private final EnrichmentData enrichment;
		private final String mic;
		private final String relationshipRecord;
		
		protected FCAUKEMIRNonReportableCollateralDataImpl(FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder builder) {
			this.enrichment = ofNullable(builder.getEnrichment()).map(f->f.build()).orElse(null);
			this.mic = builder.getMic();
			this.relationshipRecord = builder.getRelationshipRecord();
		}
		
		@Override
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enrichment")
		public EnrichmentData getEnrichment() {
			return enrichment;
		}
		
		@Override
		@RosettaAttribute("mic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mic")
		public String getMic() {
			return mic;
		}
		
		@Override
		@RosettaAttribute("relationshipRecord")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relationshipRecord")
		public String getRelationshipRecord() {
			return relationshipRecord;
		}
		
		@Override
		public FCAUKEMIRNonReportableCollateralData build() {
			return this;
		}
		
		@Override
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder toBuilder() {
			FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder builder) {
			ofNullable(getEnrichment()).ifPresent(builder::setEnrichment);
			ofNullable(getMic()).ifPresent(builder::setMic);
			ofNullable(getRelationshipRecord()).ifPresent(builder::setRelationshipRecord);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FCAUKEMIRNonReportableCollateralData _that = getType().cast(o);
		
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			if (!Objects.equals(mic, _that.getMic())) return false;
			if (!Objects.equals(relationshipRecord, _that.getRelationshipRecord())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			_result = 31 * _result + (mic != null ? mic.hashCode() : 0);
			_result = 31 * _result + (relationshipRecord != null ? relationshipRecord.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAUKEMIRNonReportableCollateralData {" +
				"enrichment=" + this.enrichment + ", " +
				"mic=" + this.mic + ", " +
				"relationshipRecord=" + this.relationshipRecord +
			'}';
		}
	}

	/*********************** Builder Implementation of FCAUKEMIRNonReportableCollateralData  ***********************/
	class FCAUKEMIRNonReportableCollateralDataBuilderImpl implements FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder {
	
		protected EnrichmentData.EnrichmentDataBuilder enrichment;
		protected String mic;
		protected String relationshipRecord;
		
		@Override
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enrichment")
		public EnrichmentData.EnrichmentDataBuilder getEnrichment() {
			return enrichment;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder getOrCreateEnrichment() {
			EnrichmentData.EnrichmentDataBuilder result;
			if (enrichment!=null) {
				result = enrichment;
			}
			else {
				result = enrichment = EnrichmentData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mic")
		public String getMic() {
			return mic;
		}
		
		@Override
		@RosettaAttribute("relationshipRecord")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relationshipRecord")
		public String getRelationshipRecord() {
			return relationshipRecord;
		}
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mic")
		@Override
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder setMic(String _mic) {
			this.mic = _mic == null ? null : _mic;
			return this;
		}
		
		@RosettaAttribute("relationshipRecord")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relationshipRecord")
		@Override
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder setRelationshipRecord(String _relationshipRecord) {
			this.relationshipRecord = _relationshipRecord == null ? null : _relationshipRecord;
			return this;
		}
		
		@Override
		public FCAUKEMIRNonReportableCollateralData build() {
			return new FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataImpl(this);
		}
		
		@Override
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder prune() {
			if (enrichment!=null && !enrichment.prune().hasData()) enrichment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEnrichment()!=null && getEnrichment().hasData()) return true;
			if (getMic()!=null) return true;
			if (getRelationshipRecord()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder o = (FCAUKEMIRNonReportableCollateralData.FCAUKEMIRNonReportableCollateralDataBuilder) other;
			
			merger.mergeRosetta(getEnrichment(), o.getEnrichment(), this::setEnrichment);
			
			merger.mergeBasic(getMic(), o.getMic(), this::setMic);
			merger.mergeBasic(getRelationshipRecord(), o.getRelationshipRecord(), this::setRelationshipRecord);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FCAUKEMIRNonReportableCollateralData _that = getType().cast(o);
		
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			if (!Objects.equals(mic, _that.getMic())) return false;
			if (!Objects.equals(relationshipRecord, _that.getRelationshipRecord())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			_result = 31 * _result + (mic != null ? mic.hashCode() : 0);
			_result = 31 * _result + (relationshipRecord != null ? relationshipRecord.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAUKEMIRNonReportableCollateralDataBuilder {" +
				"enrichment=" + this.enrichment + ", " +
				"mic=" + this.mic + ", " +
				"relationshipRecord=" + this.relationshipRecord +
			'}';
		}
	}
}
