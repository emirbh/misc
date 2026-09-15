package drr.regulation.esma.emir.refit.margin;

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
import drr.regulation.esma.emir.refit.margin.meta.ESMAEMIRNonReportableCollateralDataMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ESMAEMIRNonReportableCollateralData", builder=ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ESMAEMIRNonReportableCollateralData", model="drr", builder=ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilderImpl.class, version="7.7.0")
public interface ESMAEMIRNonReportableCollateralData extends RosettaModelObject {

	ESMAEMIRNonReportableCollateralDataMeta metaData = new ESMAEMIRNonReportableCollateralDataMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Populated by pre-enrichment process
	 */
	EnrichmentData getEnrichment();
	String getMic();

	/*********************** Build Methods  ***********************/
	ESMAEMIRNonReportableCollateralData build();
	
	ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder toBuilder();
	
	static ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder builder() {
		return new ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ESMAEMIRNonReportableCollateralData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ESMAEMIRNonReportableCollateralData> getType() {
		return ESMAEMIRNonReportableCollateralData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.class, getEnrichment());
		processor.processBasic(path.newSubPath("mic"), String.class, getMic(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ESMAEMIRNonReportableCollateralDataBuilder extends ESMAEMIRNonReportableCollateralData, RosettaModelObjectBuilder {
		EnrichmentData.EnrichmentDataBuilder getOrCreateEnrichment();
		@Override
		EnrichmentData.EnrichmentDataBuilder getEnrichment();
		ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder setEnrichment(EnrichmentData enrichment);
		ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder setMic(String mic);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.EnrichmentDataBuilder.class, getEnrichment());
			processor.processBasic(path.newSubPath("mic"), String.class, getMic(), this);
		}
		

		ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder prune();
	}

	/*********************** Immutable Implementation of ESMAEMIRNonReportableCollateralData  ***********************/
	class ESMAEMIRNonReportableCollateralDataImpl implements ESMAEMIRNonReportableCollateralData {
		private final EnrichmentData enrichment;
		private final String mic;
		
		protected ESMAEMIRNonReportableCollateralDataImpl(ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder builder) {
			this.enrichment = ofNullable(builder.getEnrichment()).map(f->f.build()).orElse(null);
			this.mic = builder.getMic();
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
		public ESMAEMIRNonReportableCollateralData build() {
			return this;
		}
		
		@Override
		public ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder toBuilder() {
			ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder builder) {
			ofNullable(getEnrichment()).ifPresent(builder::setEnrichment);
			ofNullable(getMic()).ifPresent(builder::setMic);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAEMIRNonReportableCollateralData _that = getType().cast(o);
		
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			if (!Objects.equals(mic, _that.getMic())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			_result = 31 * _result + (mic != null ? mic.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAEMIRNonReportableCollateralData {" +
				"enrichment=" + this.enrichment + ", " +
				"mic=" + this.mic +
			'}';
		}
	}

	/*********************** Builder Implementation of ESMAEMIRNonReportableCollateralData  ***********************/
	class ESMAEMIRNonReportableCollateralDataBuilderImpl implements ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder {
	
		protected EnrichmentData.EnrichmentDataBuilder enrichment;
		protected String mic;
		
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
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mic")
		@Override
		public ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder setMic(String _mic) {
			this.mic = _mic == null ? null : _mic;
			return this;
		}
		
		@Override
		public ESMAEMIRNonReportableCollateralData build() {
			return new ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataImpl(this);
		}
		
		@Override
		public ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder prune() {
			if (enrichment!=null && !enrichment.prune().hasData()) enrichment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEnrichment()!=null && getEnrichment().hasData()) return true;
			if (getMic()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder o = (ESMAEMIRNonReportableCollateralData.ESMAEMIRNonReportableCollateralDataBuilder) other;
			
			merger.mergeRosetta(getEnrichment(), o.getEnrichment(), this::setEnrichment);
			
			merger.mergeBasic(getMic(), o.getMic(), this::setMic);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAEMIRNonReportableCollateralData _that = getType().cast(o);
		
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			if (!Objects.equals(mic, _that.getMic())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			_result = 31 * _result + (mic != null ? mic.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAEMIRNonReportableCollateralDataBuilder {" +
				"enrichment=" + this.enrichment + ", " +
				"mic=" + this.mic +
			'}';
		}
	}
}
