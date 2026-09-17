package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.StrikePriceUnderlyingReferenceMeta;
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
 * Provision A pointer style reference to a product leg in the document
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A pointer style reference to a product leg in the document
 *
 */
@RosettaDataType(value="StrikePriceUnderlyingReference", builder=StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="StrikePriceUnderlyingReference", model="fpml", builder=StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilderImpl.class, version="2.1.1")
public interface StrikePriceUnderlyingReference extends Reference {

	StrikePriceUnderlyingReferenceMeta metaData = new StrikePriceUnderlyingReferenceMeta();

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
	StrikePriceUnderlyingReference build();
	
	StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder toBuilder();
	
	static StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder builder() {
		return new StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StrikePriceUnderlyingReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StrikePriceUnderlyingReference> getType() {
		return StrikePriceUnderlyingReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrikePriceUnderlyingReferenceBuilder extends StrikePriceUnderlyingReference, Reference.ReferenceBuilder {
		StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of StrikePriceUnderlyingReference  ***********************/
	class StrikePriceUnderlyingReferenceImpl extends Reference.ReferenceImpl implements StrikePriceUnderlyingReference {
		private final String href;
		
		protected StrikePriceUnderlyingReferenceImpl(StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder builder) {
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
		public StrikePriceUnderlyingReference build() {
			return this;
		}
		
		@Override
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder toBuilder() {
			StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikePriceUnderlyingReference _that = getType().cast(o);
		
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
			return "StrikePriceUnderlyingReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of StrikePriceUnderlyingReference  ***********************/
	class StrikePriceUnderlyingReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder {
	
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
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public StrikePriceUnderlyingReference build() {
			return new StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceImpl(this);
		}
		
		@Override
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder prune() {
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
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder o = (StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikePriceUnderlyingReference _that = getType().cast(o);
		
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
			return "StrikePriceUnderlyingReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
