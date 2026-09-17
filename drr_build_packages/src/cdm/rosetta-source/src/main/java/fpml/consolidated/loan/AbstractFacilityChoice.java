package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.AbstractFacilityChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="AbstractFacilityChoice", builder=AbstractFacilityChoice.AbstractFacilityChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractFacilityChoice", model="fpml", builder=AbstractFacilityChoice.AbstractFacilityChoiceBuilderImpl.class, version="2.1.1")
public interface AbstractFacilityChoice extends RosettaModelObject {

	AbstractFacilityChoiceMeta metaData = new AbstractFacilityChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that represents the accruing fixed rate option associated within a facility.
	 *
	 */
	FixedRateOption getFixedRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that represents the accruing floating rate option associated within a facility.
	 *
	 */
	LoanFloatingRateOption getFloatingRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that represents the legacy version (pre-IBOR replacement) of an accruing floating rate option associated within a facility.
	 *
	 */
	LegacyFloatingRateOption getLegacyFloatingRateOption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A description of all the letter of credit fee types which apply to the facility.
	 *
	 */
	LcOption getLcOption();

	/*********************** Build Methods  ***********************/
	AbstractFacilityChoice build();
	
	AbstractFacilityChoice.AbstractFacilityChoiceBuilder toBuilder();
	
	static AbstractFacilityChoice.AbstractFacilityChoiceBuilder builder() {
		return new AbstractFacilityChoice.AbstractFacilityChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacilityChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractFacilityChoice> getType() {
		return AbstractFacilityChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedRateOption"), processor, FixedRateOption.class, getFixedRateOption());
		processRosetta(path.newSubPath("floatingRateOption"), processor, LoanFloatingRateOption.class, getFloatingRateOption());
		processRosetta(path.newSubPath("legacyFloatingRateOption"), processor, LegacyFloatingRateOption.class, getLegacyFloatingRateOption());
		processRosetta(path.newSubPath("lcOption"), processor, LcOption.class, getLcOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFacilityChoiceBuilder extends AbstractFacilityChoice, RosettaModelObjectBuilder {
		FixedRateOption.FixedRateOptionBuilder getOrCreateFixedRateOption();
		@Override
		FixedRateOption.FixedRateOptionBuilder getFixedRateOption();
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder getOrCreateFloatingRateOption();
		@Override
		LoanFloatingRateOption.LoanFloatingRateOptionBuilder getFloatingRateOption();
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder getOrCreateLegacyFloatingRateOption();
		@Override
		LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder getLegacyFloatingRateOption();
		LcOption.LcOptionBuilder getOrCreateLcOption();
		@Override
		LcOption.LcOptionBuilder getLcOption();
		AbstractFacilityChoice.AbstractFacilityChoiceBuilder setFixedRateOption(FixedRateOption fixedRateOption);
		AbstractFacilityChoice.AbstractFacilityChoiceBuilder setFloatingRateOption(LoanFloatingRateOption floatingRateOption);
		AbstractFacilityChoice.AbstractFacilityChoiceBuilder setLegacyFloatingRateOption(LegacyFloatingRateOption legacyFloatingRateOption);
		AbstractFacilityChoice.AbstractFacilityChoiceBuilder setLcOption(LcOption lcOption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedRateOption"), processor, FixedRateOption.FixedRateOptionBuilder.class, getFixedRateOption());
			processRosetta(path.newSubPath("floatingRateOption"), processor, LoanFloatingRateOption.LoanFloatingRateOptionBuilder.class, getFloatingRateOption());
			processRosetta(path.newSubPath("legacyFloatingRateOption"), processor, LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder.class, getLegacyFloatingRateOption());
			processRosetta(path.newSubPath("lcOption"), processor, LcOption.LcOptionBuilder.class, getLcOption());
		}
		

		AbstractFacilityChoice.AbstractFacilityChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacilityChoice  ***********************/
	class AbstractFacilityChoiceImpl implements AbstractFacilityChoice {
		private final FixedRateOption fixedRateOption;
		private final LoanFloatingRateOption floatingRateOption;
		private final LegacyFloatingRateOption legacyFloatingRateOption;
		private final LcOption lcOption;
		
		protected AbstractFacilityChoiceImpl(AbstractFacilityChoice.AbstractFacilityChoiceBuilder builder) {
			this.fixedRateOption = ofNullable(builder.getFixedRateOption()).map(f->f.build()).orElse(null);
			this.floatingRateOption = ofNullable(builder.getFloatingRateOption()).map(f->f.build()).orElse(null);
			this.legacyFloatingRateOption = ofNullable(builder.getLegacyFloatingRateOption()).map(f->f.build()).orElse(null);
			this.lcOption = ofNullable(builder.getLcOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateOption")
		public FixedRateOption getFixedRateOption() {
			return fixedRateOption;
		}
		
		@Override
		@RosettaAttribute("floatingRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateOption")
		public LoanFloatingRateOption getFloatingRateOption() {
			return floatingRateOption;
		}
		
		@Override
		@RosettaAttribute("legacyFloatingRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyFloatingRateOption")
		public LegacyFloatingRateOption getLegacyFloatingRateOption() {
			return legacyFloatingRateOption;
		}
		
		@Override
		@RosettaAttribute("lcOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcOption")
		public LcOption getLcOption() {
			return lcOption;
		}
		
		@Override
		public AbstractFacilityChoice build() {
			return this;
		}
		
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder toBuilder() {
			AbstractFacilityChoice.AbstractFacilityChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacilityChoice.AbstractFacilityChoiceBuilder builder) {
			ofNullable(getFixedRateOption()).ifPresent(builder::setFixedRateOption);
			ofNullable(getFloatingRateOption()).ifPresent(builder::setFloatingRateOption);
			ofNullable(getLegacyFloatingRateOption()).ifPresent(builder::setLegacyFloatingRateOption);
			ofNullable(getLcOption()).ifPresent(builder::setLcOption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractFacilityChoice _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOption, _that.getFixedRateOption())) return false;
			if (!Objects.equals(floatingRateOption, _that.getFloatingRateOption())) return false;
			if (!Objects.equals(legacyFloatingRateOption, _that.getLegacyFloatingRateOption())) return false;
			if (!Objects.equals(lcOption, _that.getLcOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateOption != null ? fixedRateOption.hashCode() : 0);
			_result = 31 * _result + (floatingRateOption != null ? floatingRateOption.hashCode() : 0);
			_result = 31 * _result + (legacyFloatingRateOption != null ? legacyFloatingRateOption.hashCode() : 0);
			_result = 31 * _result + (lcOption != null ? lcOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityChoice {" +
				"fixedRateOption=" + this.fixedRateOption + ", " +
				"floatingRateOption=" + this.floatingRateOption + ", " +
				"legacyFloatingRateOption=" + this.legacyFloatingRateOption + ", " +
				"lcOption=" + this.lcOption +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractFacilityChoice  ***********************/
	class AbstractFacilityChoiceBuilderImpl implements AbstractFacilityChoice.AbstractFacilityChoiceBuilder {
	
		protected FixedRateOption.FixedRateOptionBuilder fixedRateOption;
		protected LoanFloatingRateOption.LoanFloatingRateOptionBuilder floatingRateOption;
		protected LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder legacyFloatingRateOption;
		protected LcOption.LcOptionBuilder lcOption;
		
		@Override
		@RosettaAttribute("fixedRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateOption")
		public FixedRateOption.FixedRateOptionBuilder getFixedRateOption() {
			return fixedRateOption;
		}
		
		@Override
		public FixedRateOption.FixedRateOptionBuilder getOrCreateFixedRateOption() {
			FixedRateOption.FixedRateOptionBuilder result;
			if (fixedRateOption!=null) {
				result = fixedRateOption;
			}
			else {
				result = fixedRateOption = FixedRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateOption")
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder getFloatingRateOption() {
			return floatingRateOption;
		}
		
		@Override
		public LoanFloatingRateOption.LoanFloatingRateOptionBuilder getOrCreateFloatingRateOption() {
			LoanFloatingRateOption.LoanFloatingRateOptionBuilder result;
			if (floatingRateOption!=null) {
				result = floatingRateOption;
			}
			else {
				result = floatingRateOption = LoanFloatingRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("legacyFloatingRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyFloatingRateOption")
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder getLegacyFloatingRateOption() {
			return legacyFloatingRateOption;
		}
		
		@Override
		public LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder getOrCreateLegacyFloatingRateOption() {
			LegacyFloatingRateOption.LegacyFloatingRateOptionBuilder result;
			if (legacyFloatingRateOption!=null) {
				result = legacyFloatingRateOption;
			}
			else {
				result = legacyFloatingRateOption = LegacyFloatingRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcOption")
		public LcOption.LcOptionBuilder getLcOption() {
			return lcOption;
		}
		
		@Override
		public LcOption.LcOptionBuilder getOrCreateLcOption() {
			LcOption.LcOptionBuilder result;
			if (lcOption!=null) {
				result = lcOption;
			}
			else {
				result = lcOption = LcOption.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fixedRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateOption")
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder setFixedRateOption(FixedRateOption _fixedRateOption) {
			this.fixedRateOption = _fixedRateOption == null ? null : _fixedRateOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateOption")
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder setFloatingRateOption(LoanFloatingRateOption _floatingRateOption) {
			this.floatingRateOption = _floatingRateOption == null ? null : _floatingRateOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("legacyFloatingRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyFloatingRateOption")
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder setLegacyFloatingRateOption(LegacyFloatingRateOption _legacyFloatingRateOption) {
			this.legacyFloatingRateOption = _legacyFloatingRateOption == null ? null : _legacyFloatingRateOption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcOption")
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder setLcOption(LcOption _lcOption) {
			this.lcOption = _lcOption == null ? null : _lcOption.toBuilder();
			return this;
		}
		
		@Override
		public AbstractFacilityChoice build() {
			return new AbstractFacilityChoice.AbstractFacilityChoiceImpl(this);
		}
		
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder prune() {
			if (fixedRateOption!=null && !fixedRateOption.prune().hasData()) fixedRateOption = null;
			if (floatingRateOption!=null && !floatingRateOption.prune().hasData()) floatingRateOption = null;
			if (legacyFloatingRateOption!=null && !legacyFloatingRateOption.prune().hasData()) legacyFloatingRateOption = null;
			if (lcOption!=null && !lcOption.prune().hasData()) lcOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRateOption()!=null && getFixedRateOption().hasData()) return true;
			if (getFloatingRateOption()!=null && getFloatingRateOption().hasData()) return true;
			if (getLegacyFloatingRateOption()!=null && getLegacyFloatingRateOption().hasData()) return true;
			if (getLcOption()!=null && getLcOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityChoice.AbstractFacilityChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractFacilityChoice.AbstractFacilityChoiceBuilder o = (AbstractFacilityChoice.AbstractFacilityChoiceBuilder) other;
			
			merger.mergeRosetta(getFixedRateOption(), o.getFixedRateOption(), this::setFixedRateOption);
			merger.mergeRosetta(getFloatingRateOption(), o.getFloatingRateOption(), this::setFloatingRateOption);
			merger.mergeRosetta(getLegacyFloatingRateOption(), o.getLegacyFloatingRateOption(), this::setLegacyFloatingRateOption);
			merger.mergeRosetta(getLcOption(), o.getLcOption(), this::setLcOption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractFacilityChoice _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOption, _that.getFixedRateOption())) return false;
			if (!Objects.equals(floatingRateOption, _that.getFloatingRateOption())) return false;
			if (!Objects.equals(legacyFloatingRateOption, _that.getLegacyFloatingRateOption())) return false;
			if (!Objects.equals(lcOption, _that.getLcOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateOption != null ? fixedRateOption.hashCode() : 0);
			_result = 31 * _result + (floatingRateOption != null ? floatingRateOption.hashCode() : 0);
			_result = 31 * _result + (legacyFloatingRateOption != null ? legacyFloatingRateOption.hashCode() : 0);
			_result = 31 * _result + (lcOption != null ? lcOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityChoiceBuilder {" +
				"fixedRateOption=" + this.fixedRateOption + ", " +
				"floatingRateOption=" + this.floatingRateOption + ", " +
				"legacyFloatingRateOption=" + this.legacyFloatingRateOption + ", " +
				"lcOption=" + this.lcOption +
			'}';
		}
	}
}
