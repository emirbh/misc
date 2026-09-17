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
import fpml.consolidated.loan.meta.EvergreenOptionMeta;
import fpml.consolidated.shared.Period;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A struture that represents an evergreen option that is available within a letter of credit instrument.
 *
 */
@RosettaDataType(value="EvergreenOption", builder=EvergreenOption.EvergreenOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EvergreenOption", model="fpml", builder=EvergreenOption.EvergreenOptionBuilderImpl.class, version="2.1.1")
public interface EvergreenOption extends RosettaModelObject {

	EvergreenOptionMeta metaData = new EvergreenOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of calendar days before the expiry of the letter of credit, that the borrower must declare an intention to extend the letter of credit.
	 *
	 */
	Period getNonRenewalNoticePeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of calendar days defining the extension period.
	 *
	 */
	Period getExtensionPeriod();

	/*********************** Build Methods  ***********************/
	EvergreenOption build();
	
	EvergreenOption.EvergreenOptionBuilder toBuilder();
	
	static EvergreenOption.EvergreenOptionBuilder builder() {
		return new EvergreenOption.EvergreenOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EvergreenOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EvergreenOption> getType() {
		return EvergreenOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("nonRenewalNoticePeriod"), processor, Period.class, getNonRenewalNoticePeriod());
		processRosetta(path.newSubPath("extensionPeriod"), processor, Period.class, getExtensionPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EvergreenOptionBuilder extends EvergreenOption, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateNonRenewalNoticePeriod();
		@Override
		Period.PeriodBuilder getNonRenewalNoticePeriod();
		Period.PeriodBuilder getOrCreateExtensionPeriod();
		@Override
		Period.PeriodBuilder getExtensionPeriod();
		EvergreenOption.EvergreenOptionBuilder setNonRenewalNoticePeriod(Period nonRenewalNoticePeriod);
		EvergreenOption.EvergreenOptionBuilder setExtensionPeriod(Period extensionPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("nonRenewalNoticePeriod"), processor, Period.PeriodBuilder.class, getNonRenewalNoticePeriod());
			processRosetta(path.newSubPath("extensionPeriod"), processor, Period.PeriodBuilder.class, getExtensionPeriod());
		}
		

		EvergreenOption.EvergreenOptionBuilder prune();
	}

	/*********************** Immutable Implementation of EvergreenOption  ***********************/
	class EvergreenOptionImpl implements EvergreenOption {
		private final Period nonRenewalNoticePeriod;
		private final Period extensionPeriod;
		
		protected EvergreenOptionImpl(EvergreenOption.EvergreenOptionBuilder builder) {
			this.nonRenewalNoticePeriod = ofNullable(builder.getNonRenewalNoticePeriod()).map(f->f.build()).orElse(null);
			this.extensionPeriod = ofNullable(builder.getExtensionPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nonRenewalNoticePeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonRenewalNoticePeriod")
		public Period getNonRenewalNoticePeriod() {
			return nonRenewalNoticePeriod;
		}
		
		@Override
		@RosettaAttribute("extensionPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("extensionPeriod")
		public Period getExtensionPeriod() {
			return extensionPeriod;
		}
		
		@Override
		public EvergreenOption build() {
			return this;
		}
		
		@Override
		public EvergreenOption.EvergreenOptionBuilder toBuilder() {
			EvergreenOption.EvergreenOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EvergreenOption.EvergreenOptionBuilder builder) {
			ofNullable(getNonRenewalNoticePeriod()).ifPresent(builder::setNonRenewalNoticePeriod);
			ofNullable(getExtensionPeriod()).ifPresent(builder::setExtensionPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EvergreenOption _that = getType().cast(o);
		
			if (!Objects.equals(nonRenewalNoticePeriod, _that.getNonRenewalNoticePeriod())) return false;
			if (!Objects.equals(extensionPeriod, _that.getExtensionPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonRenewalNoticePeriod != null ? nonRenewalNoticePeriod.hashCode() : 0);
			_result = 31 * _result + (extensionPeriod != null ? extensionPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EvergreenOption {" +
				"nonRenewalNoticePeriod=" + this.nonRenewalNoticePeriod + ", " +
				"extensionPeriod=" + this.extensionPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of EvergreenOption  ***********************/
	class EvergreenOptionBuilderImpl implements EvergreenOption.EvergreenOptionBuilder {
	
		protected Period.PeriodBuilder nonRenewalNoticePeriod;
		protected Period.PeriodBuilder extensionPeriod;
		
		@Override
		@RosettaAttribute("nonRenewalNoticePeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonRenewalNoticePeriod")
		public Period.PeriodBuilder getNonRenewalNoticePeriod() {
			return nonRenewalNoticePeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateNonRenewalNoticePeriod() {
			Period.PeriodBuilder result;
			if (nonRenewalNoticePeriod!=null) {
				result = nonRenewalNoticePeriod;
			}
			else {
				result = nonRenewalNoticePeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("extensionPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("extensionPeriod")
		public Period.PeriodBuilder getExtensionPeriod() {
			return extensionPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateExtensionPeriod() {
			Period.PeriodBuilder result;
			if (extensionPeriod!=null) {
				result = extensionPeriod;
			}
			else {
				result = extensionPeriod = Period.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("nonRenewalNoticePeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonRenewalNoticePeriod")
		@Override
		public EvergreenOption.EvergreenOptionBuilder setNonRenewalNoticePeriod(Period _nonRenewalNoticePeriod) {
			this.nonRenewalNoticePeriod = _nonRenewalNoticePeriod == null ? null : _nonRenewalNoticePeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("extensionPeriod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("extensionPeriod")
		@Override
		public EvergreenOption.EvergreenOptionBuilder setExtensionPeriod(Period _extensionPeriod) {
			this.extensionPeriod = _extensionPeriod == null ? null : _extensionPeriod.toBuilder();
			return this;
		}
		
		@Override
		public EvergreenOption build() {
			return new EvergreenOption.EvergreenOptionImpl(this);
		}
		
		@Override
		public EvergreenOption.EvergreenOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EvergreenOption.EvergreenOptionBuilder prune() {
			if (nonRenewalNoticePeriod!=null && !nonRenewalNoticePeriod.prune().hasData()) nonRenewalNoticePeriod = null;
			if (extensionPeriod!=null && !extensionPeriod.prune().hasData()) extensionPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNonRenewalNoticePeriod()!=null && getNonRenewalNoticePeriod().hasData()) return true;
			if (getExtensionPeriod()!=null && getExtensionPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EvergreenOption.EvergreenOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EvergreenOption.EvergreenOptionBuilder o = (EvergreenOption.EvergreenOptionBuilder) other;
			
			merger.mergeRosetta(getNonRenewalNoticePeriod(), o.getNonRenewalNoticePeriod(), this::setNonRenewalNoticePeriod);
			merger.mergeRosetta(getExtensionPeriod(), o.getExtensionPeriod(), this::setExtensionPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EvergreenOption _that = getType().cast(o);
		
			if (!Objects.equals(nonRenewalNoticePeriod, _that.getNonRenewalNoticePeriod())) return false;
			if (!Objects.equals(extensionPeriod, _that.getExtensionPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonRenewalNoticePeriod != null ? nonRenewalNoticePeriod.hashCode() : 0);
			_result = 31 * _result + (extensionPeriod != null ? extensionPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EvergreenOptionBuilder {" +
				"nonRenewalNoticePeriod=" + this.nonRenewalNoticePeriod + ", " +
				"extensionPeriod=" + this.extensionPeriod +
			'}';
		}
	}
}
