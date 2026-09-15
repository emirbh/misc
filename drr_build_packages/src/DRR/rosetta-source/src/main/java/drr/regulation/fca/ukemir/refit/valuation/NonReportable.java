package drr.regulation.fca.ukemir.refit.valuation;

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
import drr.regulation.fca.ukemir.refit.valuation.meta.NonReportableMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="NonReportable", builder=NonReportable.NonReportableBuilderImpl.class, version="7.7.0")
@RuneDataType(value="NonReportable", model="drr", builder=NonReportable.NonReportableBuilderImpl.class, version="7.7.0")
public interface NonReportable extends RosettaModelObject {

	NonReportableMeta metaData = new NonReportableMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Populated by pre-enrichment process
	 */
	EnrichmentData getEnrichment();

	/*********************** Build Methods  ***********************/
	NonReportable build();
	
	NonReportable.NonReportableBuilder toBuilder();
	
	static NonReportable.NonReportableBuilder builder() {
		return new NonReportable.NonReportableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonReportable> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonReportable> getType() {
		return NonReportable.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.class, getEnrichment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonReportableBuilder extends NonReportable, RosettaModelObjectBuilder {
		EnrichmentData.EnrichmentDataBuilder getOrCreateEnrichment();
		@Override
		EnrichmentData.EnrichmentDataBuilder getEnrichment();
		NonReportable.NonReportableBuilder setEnrichment(EnrichmentData enrichment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.EnrichmentDataBuilder.class, getEnrichment());
		}
		

		NonReportable.NonReportableBuilder prune();
	}

	/*********************** Immutable Implementation of NonReportable  ***********************/
	class NonReportableImpl implements NonReportable {
		private final EnrichmentData enrichment;
		
		protected NonReportableImpl(NonReportable.NonReportableBuilder builder) {
			this.enrichment = ofNullable(builder.getEnrichment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enrichment")
		public EnrichmentData getEnrichment() {
			return enrichment;
		}
		
		@Override
		public NonReportable build() {
			return this;
		}
		
		@Override
		public NonReportable.NonReportableBuilder toBuilder() {
			NonReportable.NonReportableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonReportable.NonReportableBuilder builder) {
			ofNullable(getEnrichment()).ifPresent(builder::setEnrichment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonReportable _that = getType().cast(o);
		
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonReportable {" +
				"enrichment=" + this.enrichment +
			'}';
		}
	}

	/*********************** Builder Implementation of NonReportable  ***********************/
	class NonReportableBuilderImpl implements NonReportable.NonReportableBuilder {
	
		protected EnrichmentData.EnrichmentDataBuilder enrichment;
		
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
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public NonReportable.NonReportableBuilder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@Override
		public NonReportable build() {
			return new NonReportable.NonReportableImpl(this);
		}
		
		@Override
		public NonReportable.NonReportableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonReportable.NonReportableBuilder prune() {
			if (enrichment!=null && !enrichment.prune().hasData()) enrichment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEnrichment()!=null && getEnrichment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonReportable.NonReportableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonReportable.NonReportableBuilder o = (NonReportable.NonReportableBuilder) other;
			
			merger.mergeRosetta(getEnrichment(), o.getEnrichment(), this::setEnrichment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonReportable _that = getType().cast(o);
		
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonReportableBuilder {" +
				"enrichment=" + this.enrichment +
			'}';
		}
	}
}
