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
import fpml.consolidated.shared.meta.DateReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Reference to an identified date or a complex date structure.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Reference to an identified date or a complex date structure.
 *
 */
@RosettaDataType(value="DateReference", builder=DateReference.DateReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DateReference", model="fpml", builder=DateReference.DateReferenceBuilderImpl.class, version="2.1.1")
public interface DateReference extends Reference {

	DateReferenceMeta metaData = new DateReferenceMeta();

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
	DateReference build();
	
	DateReference.DateReferenceBuilder toBuilder();
	
	static DateReference.DateReferenceBuilder builder() {
		return new DateReference.DateReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DateReference> getType() {
		return DateReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateReferenceBuilder extends DateReference, Reference.ReferenceBuilder {
		DateReference.DateReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		DateReference.DateReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of DateReference  ***********************/
	class DateReferenceImpl extends Reference.ReferenceImpl implements DateReference {
		private final String href;
		
		protected DateReferenceImpl(DateReference.DateReferenceBuilder builder) {
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
		public DateReference build() {
			return this;
		}
		
		@Override
		public DateReference.DateReferenceBuilder toBuilder() {
			DateReference.DateReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateReference.DateReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DateReference _that = getType().cast(o);
		
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
			return "DateReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DateReference  ***********************/
	class DateReferenceBuilderImpl extends Reference.ReferenceBuilderImpl implements DateReference.DateReferenceBuilder {
	
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
		public DateReference.DateReferenceBuilder setHref(String _href) {
			this.href = _href == null ? null : _href;
			return this;
		}
		
		@Override
		public DateReference build() {
			return new DateReference.DateReferenceImpl(this);
		}
		
		@Override
		public DateReference.DateReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateReference.DateReferenceBuilder prune() {
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
		public DateReference.DateReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DateReference.DateReferenceBuilder o = (DateReference.DateReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DateReference _that = getType().cast(o);
		
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
			return "DateReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
