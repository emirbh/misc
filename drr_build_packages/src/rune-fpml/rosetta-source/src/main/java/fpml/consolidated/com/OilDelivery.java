package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.OilDeliveryMeta;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The physical delivery conditions for an oil product.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The physical delivery conditions for an oil product.
 *
 */
@RosettaDataType(value="OilDelivery", builder=OilDelivery.OilDeliveryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OilDelivery", model="fpml", builder=OilDelivery.OilDeliveryBuilderImpl.class, version="2.1.1")
public interface OilDelivery extends RosettaModelObject {

	OilDeliveryMeta metaData = new OilDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specified the delivery conditions where the oil product is to be delivered by pipeline.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specified the delivery conditions where the oil product is to be delivered by pipeline.
	 *
	 */
	OilPipelineDelivery getPipeline();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specified the delivery conditions where the oil product is to be delivered by title transfer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specified the delivery conditions where the oil product is to be delivered by title transfer.
	 *
	 */
	OilTransferDelivery getTransfer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies which party is the Importer of Record for the purposes of paying customs duties and applicable taxes or costs related to the import of the oil product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies which party is the Importer of Record for the purposes of paying customs duties and applicable taxes or costs related to the import of the oil product.
	 *
	 */
	PartyReference getImporterOfRecord();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the allowable quantity tolerance as an absolute quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the allowable quantity tolerance as an absolute quantity.
	 *
	 */
	AbsoluteTolerance getAbsoluteTolerance();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the allowable quantity tolerance as a percentage of the quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the allowable quantity tolerance as a percentage of the quantity.
	 *
	 */
	PercentageTolerance getPercentageTolerance();

	/*********************** Build Methods  ***********************/
	OilDelivery build();
	
	OilDelivery.OilDeliveryBuilder toBuilder();
	
	static OilDelivery.OilDeliveryBuilder builder() {
		return new OilDelivery.OilDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilDelivery> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OilDelivery> getType() {
		return OilDelivery.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("pipeline"), processor, OilPipelineDelivery.class, getPipeline());
		processRosetta(path.newSubPath("transfer"), processor, OilTransferDelivery.class, getTransfer());
		processRosetta(path.newSubPath("importerOfRecord"), processor, PartyReference.class, getImporterOfRecord());
		processRosetta(path.newSubPath("absoluteTolerance"), processor, AbsoluteTolerance.class, getAbsoluteTolerance());
		processRosetta(path.newSubPath("percentageTolerance"), processor, PercentageTolerance.class, getPercentageTolerance());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilDeliveryBuilder extends OilDelivery, RosettaModelObjectBuilder {
		OilPipelineDelivery.OilPipelineDeliveryBuilder getOrCreatePipeline();
		@Override
		OilPipelineDelivery.OilPipelineDeliveryBuilder getPipeline();
		OilTransferDelivery.OilTransferDeliveryBuilder getOrCreateTransfer();
		@Override
		OilTransferDelivery.OilTransferDeliveryBuilder getTransfer();
		PartyReference.PartyReferenceBuilder getOrCreateImporterOfRecord();
		@Override
		PartyReference.PartyReferenceBuilder getImporterOfRecord();
		AbsoluteTolerance.AbsoluteToleranceBuilder getOrCreateAbsoluteTolerance();
		@Override
		AbsoluteTolerance.AbsoluteToleranceBuilder getAbsoluteTolerance();
		PercentageTolerance.PercentageToleranceBuilder getOrCreatePercentageTolerance();
		@Override
		PercentageTolerance.PercentageToleranceBuilder getPercentageTolerance();
		OilDelivery.OilDeliveryBuilder setPipeline(OilPipelineDelivery pipeline);
		OilDelivery.OilDeliveryBuilder setTransfer(OilTransferDelivery transfer);
		OilDelivery.OilDeliveryBuilder setImporterOfRecord(PartyReference importerOfRecord);
		OilDelivery.OilDeliveryBuilder setAbsoluteTolerance(AbsoluteTolerance absoluteTolerance);
		OilDelivery.OilDeliveryBuilder setPercentageTolerance(PercentageTolerance percentageTolerance);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("pipeline"), processor, OilPipelineDelivery.OilPipelineDeliveryBuilder.class, getPipeline());
			processRosetta(path.newSubPath("transfer"), processor, OilTransferDelivery.OilTransferDeliveryBuilder.class, getTransfer());
			processRosetta(path.newSubPath("importerOfRecord"), processor, PartyReference.PartyReferenceBuilder.class, getImporterOfRecord());
			processRosetta(path.newSubPath("absoluteTolerance"), processor, AbsoluteTolerance.AbsoluteToleranceBuilder.class, getAbsoluteTolerance());
			processRosetta(path.newSubPath("percentageTolerance"), processor, PercentageTolerance.PercentageToleranceBuilder.class, getPercentageTolerance());
		}
		

		OilDelivery.OilDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of OilDelivery  ***********************/
	class OilDeliveryImpl implements OilDelivery {
		private final OilPipelineDelivery pipeline;
		private final OilTransferDelivery transfer;
		private final PartyReference importerOfRecord;
		private final AbsoluteTolerance absoluteTolerance;
		private final PercentageTolerance percentageTolerance;
		
		protected OilDeliveryImpl(OilDelivery.OilDeliveryBuilder builder) {
			this.pipeline = ofNullable(builder.getPipeline()).map(f->f.build()).orElse(null);
			this.transfer = ofNullable(builder.getTransfer()).map(f->f.build()).orElse(null);
			this.importerOfRecord = ofNullable(builder.getImporterOfRecord()).map(f->f.build()).orElse(null);
			this.absoluteTolerance = ofNullable(builder.getAbsoluteTolerance()).map(f->f.build()).orElse(null);
			this.percentageTolerance = ofNullable(builder.getPercentageTolerance()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("pipeline")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pipeline")
		public OilPipelineDelivery getPipeline() {
			return pipeline;
		}
		
		@Override
		@RosettaAttribute("transfer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transfer")
		public OilTransferDelivery getTransfer() {
			return transfer;
		}
		
		@Override
		@RosettaAttribute("importerOfRecord")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("importerOfRecord")
		public PartyReference getImporterOfRecord() {
			return importerOfRecord;
		}
		
		@Override
		@RosettaAttribute("absoluteTolerance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("absoluteTolerance")
		public AbsoluteTolerance getAbsoluteTolerance() {
			return absoluteTolerance;
		}
		
		@Override
		@RosettaAttribute("percentageTolerance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("percentageTolerance")
		public PercentageTolerance getPercentageTolerance() {
			return percentageTolerance;
		}
		
		@Override
		public OilDelivery build() {
			return this;
		}
		
		@Override
		public OilDelivery.OilDeliveryBuilder toBuilder() {
			OilDelivery.OilDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilDelivery.OilDeliveryBuilder builder) {
			ofNullable(getPipeline()).ifPresent(builder::setPipeline);
			ofNullable(getTransfer()).ifPresent(builder::setTransfer);
			ofNullable(getImporterOfRecord()).ifPresent(builder::setImporterOfRecord);
			ofNullable(getAbsoluteTolerance()).ifPresent(builder::setAbsoluteTolerance);
			ofNullable(getPercentageTolerance()).ifPresent(builder::setPercentageTolerance);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilDelivery _that = getType().cast(o);
		
			if (!Objects.equals(pipeline, _that.getPipeline())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			if (!Objects.equals(importerOfRecord, _that.getImporterOfRecord())) return false;
			if (!Objects.equals(absoluteTolerance, _that.getAbsoluteTolerance())) return false;
			if (!Objects.equals(percentageTolerance, _that.getPercentageTolerance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pipeline != null ? pipeline.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			_result = 31 * _result + (importerOfRecord != null ? importerOfRecord.hashCode() : 0);
			_result = 31 * _result + (absoluteTolerance != null ? absoluteTolerance.hashCode() : 0);
			_result = 31 * _result + (percentageTolerance != null ? percentageTolerance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilDelivery {" +
				"pipeline=" + this.pipeline + ", " +
				"transfer=" + this.transfer + ", " +
				"importerOfRecord=" + this.importerOfRecord + ", " +
				"absoluteTolerance=" + this.absoluteTolerance + ", " +
				"percentageTolerance=" + this.percentageTolerance +
			'}';
		}
	}

	/*********************** Builder Implementation of OilDelivery  ***********************/
	class OilDeliveryBuilderImpl implements OilDelivery.OilDeliveryBuilder {
	
		protected OilPipelineDelivery.OilPipelineDeliveryBuilder pipeline;
		protected OilTransferDelivery.OilTransferDeliveryBuilder transfer;
		protected PartyReference.PartyReferenceBuilder importerOfRecord;
		protected AbsoluteTolerance.AbsoluteToleranceBuilder absoluteTolerance;
		protected PercentageTolerance.PercentageToleranceBuilder percentageTolerance;
		
		@Override
		@RosettaAttribute("pipeline")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pipeline")
		public OilPipelineDelivery.OilPipelineDeliveryBuilder getPipeline() {
			return pipeline;
		}
		
		@Override
		public OilPipelineDelivery.OilPipelineDeliveryBuilder getOrCreatePipeline() {
			OilPipelineDelivery.OilPipelineDeliveryBuilder result;
			if (pipeline!=null) {
				result = pipeline;
			}
			else {
				result = pipeline = OilPipelineDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transfer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transfer")
		public OilTransferDelivery.OilTransferDeliveryBuilder getTransfer() {
			return transfer;
		}
		
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder getOrCreateTransfer() {
			OilTransferDelivery.OilTransferDeliveryBuilder result;
			if (transfer!=null) {
				result = transfer;
			}
			else {
				result = transfer = OilTransferDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("importerOfRecord")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("importerOfRecord")
		public PartyReference.PartyReferenceBuilder getImporterOfRecord() {
			return importerOfRecord;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateImporterOfRecord() {
			PartyReference.PartyReferenceBuilder result;
			if (importerOfRecord!=null) {
				result = importerOfRecord;
			}
			else {
				result = importerOfRecord = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("absoluteTolerance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("absoluteTolerance")
		public AbsoluteTolerance.AbsoluteToleranceBuilder getAbsoluteTolerance() {
			return absoluteTolerance;
		}
		
		@Override
		public AbsoluteTolerance.AbsoluteToleranceBuilder getOrCreateAbsoluteTolerance() {
			AbsoluteTolerance.AbsoluteToleranceBuilder result;
			if (absoluteTolerance!=null) {
				result = absoluteTolerance;
			}
			else {
				result = absoluteTolerance = AbsoluteTolerance.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("percentageTolerance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("percentageTolerance")
		public PercentageTolerance.PercentageToleranceBuilder getPercentageTolerance() {
			return percentageTolerance;
		}
		
		@Override
		public PercentageTolerance.PercentageToleranceBuilder getOrCreatePercentageTolerance() {
			PercentageTolerance.PercentageToleranceBuilder result;
			if (percentageTolerance!=null) {
				result = percentageTolerance;
			}
			else {
				result = percentageTolerance = PercentageTolerance.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("pipeline")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pipeline")
		@Override
		public OilDelivery.OilDeliveryBuilder setPipeline(OilPipelineDelivery _pipeline) {
			this.pipeline = _pipeline == null ? null : _pipeline.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transfer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transfer")
		@Override
		public OilDelivery.OilDeliveryBuilder setTransfer(OilTransferDelivery _transfer) {
			this.transfer = _transfer == null ? null : _transfer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("importerOfRecord")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("importerOfRecord")
		@Override
		public OilDelivery.OilDeliveryBuilder setImporterOfRecord(PartyReference _importerOfRecord) {
			this.importerOfRecord = _importerOfRecord == null ? null : _importerOfRecord.toBuilder();
			return this;
		}
		
		@RosettaAttribute("absoluteTolerance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("absoluteTolerance")
		@Override
		public OilDelivery.OilDeliveryBuilder setAbsoluteTolerance(AbsoluteTolerance _absoluteTolerance) {
			this.absoluteTolerance = _absoluteTolerance == null ? null : _absoluteTolerance.toBuilder();
			return this;
		}
		
		@RosettaAttribute("percentageTolerance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("percentageTolerance")
		@Override
		public OilDelivery.OilDeliveryBuilder setPercentageTolerance(PercentageTolerance _percentageTolerance) {
			this.percentageTolerance = _percentageTolerance == null ? null : _percentageTolerance.toBuilder();
			return this;
		}
		
		@Override
		public OilDelivery build() {
			return new OilDelivery.OilDeliveryImpl(this);
		}
		
		@Override
		public OilDelivery.OilDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilDelivery.OilDeliveryBuilder prune() {
			if (pipeline!=null && !pipeline.prune().hasData()) pipeline = null;
			if (transfer!=null && !transfer.prune().hasData()) transfer = null;
			if (importerOfRecord!=null && !importerOfRecord.prune().hasData()) importerOfRecord = null;
			if (absoluteTolerance!=null && !absoluteTolerance.prune().hasData()) absoluteTolerance = null;
			if (percentageTolerance!=null && !percentageTolerance.prune().hasData()) percentageTolerance = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPipeline()!=null && getPipeline().hasData()) return true;
			if (getTransfer()!=null && getTransfer().hasData()) return true;
			if (getImporterOfRecord()!=null && getImporterOfRecord().hasData()) return true;
			if (getAbsoluteTolerance()!=null && getAbsoluteTolerance().hasData()) return true;
			if (getPercentageTolerance()!=null && getPercentageTolerance().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilDelivery.OilDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OilDelivery.OilDeliveryBuilder o = (OilDelivery.OilDeliveryBuilder) other;
			
			merger.mergeRosetta(getPipeline(), o.getPipeline(), this::setPipeline);
			merger.mergeRosetta(getTransfer(), o.getTransfer(), this::setTransfer);
			merger.mergeRosetta(getImporterOfRecord(), o.getImporterOfRecord(), this::setImporterOfRecord);
			merger.mergeRosetta(getAbsoluteTolerance(), o.getAbsoluteTolerance(), this::setAbsoluteTolerance);
			merger.mergeRosetta(getPercentageTolerance(), o.getPercentageTolerance(), this::setPercentageTolerance);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilDelivery _that = getType().cast(o);
		
			if (!Objects.equals(pipeline, _that.getPipeline())) return false;
			if (!Objects.equals(transfer, _that.getTransfer())) return false;
			if (!Objects.equals(importerOfRecord, _that.getImporterOfRecord())) return false;
			if (!Objects.equals(absoluteTolerance, _that.getAbsoluteTolerance())) return false;
			if (!Objects.equals(percentageTolerance, _that.getPercentageTolerance())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pipeline != null ? pipeline.hashCode() : 0);
			_result = 31 * _result + (transfer != null ? transfer.hashCode() : 0);
			_result = 31 * _result + (importerOfRecord != null ? importerOfRecord.hashCode() : 0);
			_result = 31 * _result + (absoluteTolerance != null ? absoluteTolerance.hashCode() : 0);
			_result = 31 * _result + (percentageTolerance != null ? percentageTolerance.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilDeliveryBuilder {" +
				"pipeline=" + this.pipeline + ", " +
				"transfer=" + this.transfer + ", " +
				"importerOfRecord=" + this.importerOfRecord + ", " +
				"absoluteTolerance=" + this.absoluteTolerance + ", " +
				"percentageTolerance=" + this.percentageTolerance +
			'}';
		}
	}
}
