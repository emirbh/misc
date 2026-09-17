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
import fpml.consolidated.com.meta.StrikePriceBasketReferenceMeta;
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
 * Provision A pointer style reference to a basket in the document
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A pointer style reference to a basket in the document
 *
 */
@RosettaDataType(value="StrikePriceBasketReference", builder=StrikePriceBasketReference.StrikePriceBasketReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="StrikePriceBasketReference", model="fpml", builder=StrikePriceBasketReference.StrikePriceBasketReferenceBuilderImpl.class, version="2.1.1")
public interface StrikePriceBasketReference extends Reference {

	StrikePriceBasketReferenceMeta metaData = new StrikePriceBasketReferenceMeta();

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
	StrikePriceBasketReference build();
	
	StrikePriceBasketReference.StrikePriceBasketReferenceBuilder toBuilder();
	
	static StrikePriceBasketReference.StrikePriceBasketReferenceBuilder builder() {
		return new StrikePriceBasketReference.StrikePriceBasketReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StrikePriceBasketReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StrikePriceBasketReference> getType() {
		return StrikePriceBasketReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrikePriceBasketReferenceBuilder extends StrikePriceBasketReference, Reference.ReferenceBuilder {
		StrikePriceBasketReference.StrikePriceBasketReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		StrikePriceBasketReference.StrikePriceBasketReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of StrikePriceBasketReference  ***********************/
	class StrikePriceBasketReferenceImpl extends Reference.ReferenceImpl implements StrikePriceBasketReference {
		private final String href;
		
		protected StrikePriceBasketReferenceImpl(StrikePriceBasketReference.StrikePriceBasketReferenceBuilder builder) {
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
		public StrikePriceBasketReference build() {
			return this;
		}
		
		@Override
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder toBuilder() {
			StrikePriceBasketReference.StrikePriceBasketReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrikePriceBasketReference.StrikePriceBasketReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikePriceBasketReference _that = getType().cast(o);
		
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
			return "StrikePriceBasketReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of StrikePriceBasketReference  ***********************/
	class StrikePriceBasketReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements StrikePriceBasketReference.StrikePriceBasketReferenceBuilder {
	
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
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public StrikePriceBasketReference build() {
			return new StrikePriceBasketReference.StrikePriceBasketReferenceImpl(this);
		}
		
		@Override
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder prune() {
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
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			StrikePriceBasketReference.StrikePriceBasketReferenceBuilder o = (StrikePriceBasketReference.StrikePriceBasketReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikePriceBasketReference _that = getType().cast(o);
		
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
			return "StrikePriceBasketReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
