package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.IndexAdjustmentEventsMeta;
import fpml.consolidated.fpmlenum.IndexEventConsequenceEnum;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines the specification of the consequences of Index Events as defined by the 2002 ISDA Equity Derivatives Definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the specification of the consequences of Index Events as defined by the 2002 ISDA Equity Derivatives Definitions.
 *
 */
@RosettaDataType(value="IndexAdjustmentEvents", builder=IndexAdjustmentEvents.IndexAdjustmentEventsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IndexAdjustmentEvents", model="fpml", builder=IndexAdjustmentEvents.IndexAdjustmentEventsBuilderImpl.class, version="2.1.1")
public interface IndexAdjustmentEvents extends RosettaModelObject {

	IndexAdjustmentEventsMeta metaData = new IndexAdjustmentEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Consequence of index modification.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Consequence of index modification.
	 *
	 */
	IndexEventConsequenceEnum getIndexModification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Consequence of index cancellation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Consequence of index cancellation.
	 *
	 */
	IndexEventConsequenceEnum getIndexCancellation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Consequence of index disruption.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Consequence of index disruption.
	 *
	 */
	IndexEventConsequenceEnum getIndexDisruption();

	/*********************** Build Methods  ***********************/
	IndexAdjustmentEvents build();
	
	IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder();
	
	static IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder() {
		return new IndexAdjustmentEvents.IndexAdjustmentEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexAdjustmentEvents> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndexAdjustmentEvents> getType() {
		return IndexAdjustmentEvents.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("indexModification"), IndexEventConsequenceEnum.class, getIndexModification(), this);
		processor.processBasic(path.newSubPath("indexCancellation"), IndexEventConsequenceEnum.class, getIndexCancellation(), this);
		processor.processBasic(path.newSubPath("indexDisruption"), IndexEventConsequenceEnum.class, getIndexDisruption(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexAdjustmentEventsBuilder extends IndexAdjustmentEvents, RosettaModelObjectBuilder {
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexModification(IndexEventConsequenceEnum indexModification);
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexCancellation(IndexEventConsequenceEnum indexCancellation);
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexDisruption(IndexEventConsequenceEnum indexDisruption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("indexModification"), IndexEventConsequenceEnum.class, getIndexModification(), this);
			processor.processBasic(path.newSubPath("indexCancellation"), IndexEventConsequenceEnum.class, getIndexCancellation(), this);
			processor.processBasic(path.newSubPath("indexDisruption"), IndexEventConsequenceEnum.class, getIndexDisruption(), this);
		}
		

		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder prune();
	}

	/*********************** Immutable Implementation of IndexAdjustmentEvents  ***********************/
	class IndexAdjustmentEventsImpl implements IndexAdjustmentEvents {
		private final IndexEventConsequenceEnum indexModification;
		private final IndexEventConsequenceEnum indexCancellation;
		private final IndexEventConsequenceEnum indexDisruption;
		
		protected IndexAdjustmentEventsImpl(IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder) {
			this.indexModification = builder.getIndexModification();
			this.indexCancellation = builder.getIndexCancellation();
			this.indexDisruption = builder.getIndexDisruption();
		}
		
		@Override
		@RosettaAttribute("indexModification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexModification")
		public IndexEventConsequenceEnum getIndexModification() {
			return indexModification;
		}
		
		@Override
		@RosettaAttribute("indexCancellation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexCancellation")
		public IndexEventConsequenceEnum getIndexCancellation() {
			return indexCancellation;
		}
		
		@Override
		@RosettaAttribute("indexDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexDisruption")
		public IndexEventConsequenceEnum getIndexDisruption() {
			return indexDisruption;
		}
		
		@Override
		public IndexAdjustmentEvents build() {
			return this;
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder() {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexAdjustmentEvents.IndexAdjustmentEventsBuilder builder) {
			ofNullable(getIndexModification()).ifPresent(builder::setIndexModification);
			ofNullable(getIndexCancellation()).ifPresent(builder::setIndexCancellation);
			ofNullable(getIndexDisruption()).ifPresent(builder::setIndexDisruption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAdjustmentEvents _that = getType().cast(o);
		
			if (!Objects.equals(indexModification, _that.getIndexModification())) return false;
			if (!Objects.equals(indexCancellation, _that.getIndexCancellation())) return false;
			if (!Objects.equals(indexDisruption, _that.getIndexDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexModification != null ? indexModification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexCancellation != null ? indexCancellation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexDisruption != null ? indexDisruption.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAdjustmentEvents {" +
				"indexModification=" + this.indexModification + ", " +
				"indexCancellation=" + this.indexCancellation + ", " +
				"indexDisruption=" + this.indexDisruption +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexAdjustmentEvents  ***********************/
	class IndexAdjustmentEventsBuilderImpl implements IndexAdjustmentEvents.IndexAdjustmentEventsBuilder {
	
		protected IndexEventConsequenceEnum indexModification;
		protected IndexEventConsequenceEnum indexCancellation;
		protected IndexEventConsequenceEnum indexDisruption;
		
		@Override
		@RosettaAttribute("indexModification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexModification")
		public IndexEventConsequenceEnum getIndexModification() {
			return indexModification;
		}
		
		@Override
		@RosettaAttribute("indexCancellation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexCancellation")
		public IndexEventConsequenceEnum getIndexCancellation() {
			return indexCancellation;
		}
		
		@Override
		@RosettaAttribute("indexDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexDisruption")
		public IndexEventConsequenceEnum getIndexDisruption() {
			return indexDisruption;
		}
		
		@RosettaAttribute("indexModification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexModification")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexModification(IndexEventConsequenceEnum _indexModification) {
			this.indexModification = _indexModification == null ? null : _indexModification;
			return this;
		}
		
		@RosettaAttribute("indexCancellation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexCancellation")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexCancellation(IndexEventConsequenceEnum _indexCancellation) {
			this.indexCancellation = _indexCancellation == null ? null : _indexCancellation;
			return this;
		}
		
		@RosettaAttribute("indexDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexDisruption")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder setIndexDisruption(IndexEventConsequenceEnum _indexDisruption) {
			this.indexDisruption = _indexDisruption == null ? null : _indexDisruption;
			return this;
		}
		
		@Override
		public IndexAdjustmentEvents build() {
			return new IndexAdjustmentEvents.IndexAdjustmentEventsImpl(this);
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndexModification()!=null) return true;
			if (getIndexCancellation()!=null) return true;
			if (getIndexDisruption()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder o = (IndexAdjustmentEvents.IndexAdjustmentEventsBuilder) other;
			
			
			merger.mergeBasic(getIndexModification(), o.getIndexModification(), this::setIndexModification);
			merger.mergeBasic(getIndexCancellation(), o.getIndexCancellation(), this::setIndexCancellation);
			merger.mergeBasic(getIndexDisruption(), o.getIndexDisruption(), this::setIndexDisruption);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAdjustmentEvents _that = getType().cast(o);
		
			if (!Objects.equals(indexModification, _that.getIndexModification())) return false;
			if (!Objects.equals(indexCancellation, _that.getIndexCancellation())) return false;
			if (!Objects.equals(indexDisruption, _that.getIndexDisruption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indexModification != null ? indexModification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexCancellation != null ? indexCancellation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexDisruption != null ? indexDisruption.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAdjustmentEventsBuilder {" +
				"indexModification=" + this.indexModification + ", " +
				"indexCancellation=" + this.indexCancellation + ", " +
				"indexDisruption=" + this.indexDisruption +
			'}';
		}
	}
}
