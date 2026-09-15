package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.TaxFormMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that defines a tax form registration.
 *
 */
@RosettaDataType(value="TaxForm", builder=TaxForm.TaxFormBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TaxForm", model="fpml", builder=TaxForm.TaxFormBuilderImpl.class, version="2.1.1")
public interface TaxForm extends RosettaModelObject {

	TaxFormMeta metaData = new TaxFormMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Type of tax form registered.
	 *
	 */
	TaxFormType getTaxFormType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date of expiration of this tax form.
	 *
	 */
	ZonedDateTime getTaxFormExpiryDate();

	/*********************** Build Methods  ***********************/
	TaxForm build();
	
	TaxForm.TaxFormBuilder toBuilder();
	
	static TaxForm.TaxFormBuilder builder() {
		return new TaxForm.TaxFormBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TaxForm> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TaxForm> getType() {
		return TaxForm.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("taxFormType"), processor, TaxFormType.class, getTaxFormType());
		processor.processBasic(path.newSubPath("taxFormExpiryDate"), ZonedDateTime.class, getTaxFormExpiryDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TaxFormBuilder extends TaxForm, RosettaModelObjectBuilder {
		TaxFormType.TaxFormTypeBuilder getOrCreateTaxFormType();
		@Override
		TaxFormType.TaxFormTypeBuilder getTaxFormType();
		TaxForm.TaxFormBuilder setTaxFormType(TaxFormType taxFormType);
		TaxForm.TaxFormBuilder setTaxFormExpiryDate(ZonedDateTime taxFormExpiryDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("taxFormType"), processor, TaxFormType.TaxFormTypeBuilder.class, getTaxFormType());
			processor.processBasic(path.newSubPath("taxFormExpiryDate"), ZonedDateTime.class, getTaxFormExpiryDate(), this);
		}
		

		TaxForm.TaxFormBuilder prune();
	}

	/*********************** Immutable Implementation of TaxForm  ***********************/
	class TaxFormImpl implements TaxForm {
		private final TaxFormType taxFormType;
		private final ZonedDateTime taxFormExpiryDate;
		
		protected TaxFormImpl(TaxForm.TaxFormBuilder builder) {
			this.taxFormType = ofNullable(builder.getTaxFormType()).map(f->f.build()).orElse(null);
			this.taxFormExpiryDate = builder.getTaxFormExpiryDate();
		}
		
		@Override
		@RosettaAttribute("taxFormType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taxFormType")
		public TaxFormType getTaxFormType() {
			return taxFormType;
		}
		
		@Override
		@RosettaAttribute("taxFormExpiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("taxFormExpiryDate")
		public ZonedDateTime getTaxFormExpiryDate() {
			return taxFormExpiryDate;
		}
		
		@Override
		public TaxForm build() {
			return this;
		}
		
		@Override
		public TaxForm.TaxFormBuilder toBuilder() {
			TaxForm.TaxFormBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TaxForm.TaxFormBuilder builder) {
			ofNullable(getTaxFormType()).ifPresent(builder::setTaxFormType);
			ofNullable(getTaxFormExpiryDate()).ifPresent(builder::setTaxFormExpiryDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaxForm _that = getType().cast(o);
		
			if (!Objects.equals(taxFormType, _that.getTaxFormType())) return false;
			if (!Objects.equals(taxFormExpiryDate, _that.getTaxFormExpiryDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taxFormType != null ? taxFormType.hashCode() : 0);
			_result = 31 * _result + (taxFormExpiryDate != null ? taxFormExpiryDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaxForm {" +
				"taxFormType=" + this.taxFormType + ", " +
				"taxFormExpiryDate=" + this.taxFormExpiryDate +
			'}';
		}
	}

	/*********************** Builder Implementation of TaxForm  ***********************/
	class TaxFormBuilderImpl implements TaxForm.TaxFormBuilder {
	
		protected TaxFormType.TaxFormTypeBuilder taxFormType;
		protected ZonedDateTime taxFormExpiryDate;
		
		@Override
		@RosettaAttribute("taxFormType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("taxFormType")
		public TaxFormType.TaxFormTypeBuilder getTaxFormType() {
			return taxFormType;
		}
		
		@Override
		public TaxFormType.TaxFormTypeBuilder getOrCreateTaxFormType() {
			TaxFormType.TaxFormTypeBuilder result;
			if (taxFormType!=null) {
				result = taxFormType;
			}
			else {
				result = taxFormType = TaxFormType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taxFormExpiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("taxFormExpiryDate")
		public ZonedDateTime getTaxFormExpiryDate() {
			return taxFormExpiryDate;
		}
		
		@RosettaAttribute("taxFormType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("taxFormType")
		@Override
		public TaxForm.TaxFormBuilder setTaxFormType(TaxFormType _taxFormType) {
			this.taxFormType = _taxFormType == null ? null : _taxFormType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("taxFormExpiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("taxFormExpiryDate")
		@Override
		public TaxForm.TaxFormBuilder setTaxFormExpiryDate(ZonedDateTime _taxFormExpiryDate) {
			this.taxFormExpiryDate = _taxFormExpiryDate == null ? null : _taxFormExpiryDate;
			return this;
		}
		
		@Override
		public TaxForm build() {
			return new TaxForm.TaxFormImpl(this);
		}
		
		@Override
		public TaxForm.TaxFormBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaxForm.TaxFormBuilder prune() {
			if (taxFormType!=null && !taxFormType.prune().hasData()) taxFormType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTaxFormType()!=null && getTaxFormType().hasData()) return true;
			if (getTaxFormExpiryDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TaxForm.TaxFormBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TaxForm.TaxFormBuilder o = (TaxForm.TaxFormBuilder) other;
			
			merger.mergeRosetta(getTaxFormType(), o.getTaxFormType(), this::setTaxFormType);
			
			merger.mergeBasic(getTaxFormExpiryDate(), o.getTaxFormExpiryDate(), this::setTaxFormExpiryDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TaxForm _that = getType().cast(o);
		
			if (!Objects.equals(taxFormType, _that.getTaxFormType())) return false;
			if (!Objects.equals(taxFormExpiryDate, _that.getTaxFormExpiryDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taxFormType != null ? taxFormType.hashCode() : 0);
			_result = 31 * _result + (taxFormExpiryDate != null ? taxFormExpiryDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TaxFormBuilder {" +
				"taxFormType=" + this.taxFormType + ", " +
				"taxFormExpiryDate=" + this.taxFormExpiryDate +
			'}';
		}
	}
}
