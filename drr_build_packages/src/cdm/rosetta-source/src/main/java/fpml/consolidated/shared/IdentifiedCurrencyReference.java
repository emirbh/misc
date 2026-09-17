package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.IdentifiedCurrencyReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Reference to a currency with ID attribute
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to a currency with ID attribute
 *
 */
@RosettaDataType(value="IdentifiedCurrencyReference", builder=IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IdentifiedCurrencyReference", model="fpml", builder=IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilderImpl.class, version="2.1.1")
public interface IdentifiedCurrencyReference extends Reference {

	IdentifiedCurrencyReferenceMeta metaData = new IdentifiedCurrencyReferenceMeta();

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
	IdentifiedCurrencyReference build();
	
	IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder toBuilder();
	
	static IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder builder() {
		return new IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedCurrencyReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IdentifiedCurrencyReference> getType() {
		return IdentifiedCurrencyReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedCurrencyReferenceBuilder extends IdentifiedCurrencyReference, Reference.ReferenceBuilder {
		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedCurrencyReference  ***********************/
	class IdentifiedCurrencyReferenceImpl extends Reference.ReferenceImpl implements IdentifiedCurrencyReference {
		private final String href;
		
		protected IdentifiedCurrencyReferenceImpl(IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder builder) {
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
		public IdentifiedCurrencyReference build() {
			return this;
		}
		
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder toBuilder() {
			IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedCurrencyReference _that = getType().cast(o);
		
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
			return "IdentifiedCurrencyReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IdentifiedCurrencyReference  ***********************/
	class IdentifiedCurrencyReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder {
	
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
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public IdentifiedCurrencyReference build() {
			return new IdentifiedCurrencyReference.IdentifiedCurrencyReferenceImpl(this);
		}
		
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder prune() {
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
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder o = (IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedCurrencyReference _that = getType().cast(o);
		
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
			return "IdentifiedCurrencyReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
