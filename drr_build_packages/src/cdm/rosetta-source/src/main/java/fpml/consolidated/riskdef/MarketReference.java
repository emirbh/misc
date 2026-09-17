package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.MarketReferenceMeta;
import fpml.consolidated.shared.Reference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Reference to a market structure.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to a market structure.
 *
 */
@RosettaDataType(value="MarketReference", builder=MarketReference.MarketReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MarketReference", model="fpml", builder=MarketReference.MarketReferenceBuilderImpl.class, version="2.1.1")
public interface MarketReference extends Reference {

	MarketReferenceMeta metaData = new MarketReferenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getHref();

	/*********************** Build Methods  ***********************/
	MarketReference build();
	
	MarketReference.MarketReferenceBuilder toBuilder();
	
	static MarketReference.MarketReferenceBuilder builder() {
		return new MarketReference.MarketReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarketReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarketReference> getType() {
		return MarketReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarketReferenceBuilder extends MarketReference, Reference.ReferenceBuilder {
		MarketReference.MarketReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		MarketReference.MarketReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of MarketReference  ***********************/
	class MarketReferenceImpl extends Reference.ReferenceImpl implements MarketReference {
		private final String href;
		
		protected MarketReferenceImpl(MarketReference.MarketReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public MarketReference build() {
			return this;
		}
		
		@Override
		public MarketReference.MarketReferenceBuilder toBuilder() {
			MarketReference.MarketReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarketReference.MarketReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MarketReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarketReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MarketReference  ***********************/
	class MarketReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements MarketReference.MarketReferenceBuilder {
	
		protected String href;
		
		@Override
		@RosettaAttribute("href")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("href")
		public String getHref() {
			return href;
		}
		
		@RosettaAttribute("href")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("href")
		@Override
		public MarketReference.MarketReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public MarketReference build() {
			return new MarketReference.MarketReferenceImpl(this);
		}
		
		@Override
		public MarketReference.MarketReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarketReference.MarketReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarketReference.MarketReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MarketReference.MarketReferenceBuilder o = (MarketReference.MarketReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MarketReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarketReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
