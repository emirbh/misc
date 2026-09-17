package cdm.legaldocumentation.master.isda;

import cdm.legaldocumentation.common.TerminationCurrencyConditionEnum;
import cdm.legaldocumentation.master.isda.meta.PartyOptionTerminationCurrencyMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies mechanism for Termination currency to be selected by the Non-defaulting Party/party which is not the Affected Party.
 * @version 6.23.0
 */
@RosettaDataType(value="PartyOptionTerminationCurrency", builder=PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PartyOptionTerminationCurrency", model="cdm", builder=PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilderImpl.class, version="6.23.0")
public interface PartyOptionTerminationCurrency extends RosettaModelObject {

	PartyOptionTerminationCurrencyMeta metaData = new PartyOptionTerminationCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies termination currency where there are two Affected Parties and they cannot agree on the termination currency.
	 */
	String getBothAffectedTermCurrencyOption();
	/**
	 * Specifies alternative conditions for selection of the termination currency.
	 */
	String getTerminationCurrencySpecifiedCondition();
	/**
	 * Specifies the enumerated conditions for selection of the termination currency.
	 */
	TerminationCurrencyConditionEnum getTerminationCurrencyCondition();

	/*********************** Build Methods  ***********************/
	PartyOptionTerminationCurrency build();
	
	PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder toBuilder();
	
	static PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder builder() {
		return new PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyOptionTerminationCurrency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyOptionTerminationCurrency> getType() {
		return PartyOptionTerminationCurrency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bothAffectedTermCurrencyOption"), String.class, getBothAffectedTermCurrencyOption(), this);
		processor.processBasic(path.newSubPath("terminationCurrencySpecifiedCondition"), String.class, getTerminationCurrencySpecifiedCondition(), this);
		processor.processBasic(path.newSubPath("terminationCurrencyCondition"), TerminationCurrencyConditionEnum.class, getTerminationCurrencyCondition(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyOptionTerminationCurrencyBuilder extends PartyOptionTerminationCurrency, RosettaModelObjectBuilder {
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setBothAffectedTermCurrencyOption(String bothAffectedTermCurrencyOption);
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setTerminationCurrencySpecifiedCondition(String terminationCurrencySpecifiedCondition);
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setTerminationCurrencyCondition(TerminationCurrencyConditionEnum terminationCurrencyCondition);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("bothAffectedTermCurrencyOption"), String.class, getBothAffectedTermCurrencyOption(), this);
			processor.processBasic(path.newSubPath("terminationCurrencySpecifiedCondition"), String.class, getTerminationCurrencySpecifiedCondition(), this);
			processor.processBasic(path.newSubPath("terminationCurrencyCondition"), TerminationCurrencyConditionEnum.class, getTerminationCurrencyCondition(), this);
		}
		

		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of PartyOptionTerminationCurrency  ***********************/
	class PartyOptionTerminationCurrencyImpl implements PartyOptionTerminationCurrency {
		private final String bothAffectedTermCurrencyOption;
		private final String terminationCurrencySpecifiedCondition;
		private final TerminationCurrencyConditionEnum terminationCurrencyCondition;
		
		protected PartyOptionTerminationCurrencyImpl(PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder builder) {
			this.bothAffectedTermCurrencyOption = builder.getBothAffectedTermCurrencyOption();
			this.terminationCurrencySpecifiedCondition = builder.getTerminationCurrencySpecifiedCondition();
			this.terminationCurrencyCondition = builder.getTerminationCurrencyCondition();
		}
		
		@Override
		@RosettaAttribute("bothAffectedTermCurrencyOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bothAffectedTermCurrencyOption")
		public String getBothAffectedTermCurrencyOption() {
			return bothAffectedTermCurrencyOption;
		}
		
		@Override
		@RosettaAttribute("terminationCurrencySpecifiedCondition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationCurrencySpecifiedCondition")
		public String getTerminationCurrencySpecifiedCondition() {
			return terminationCurrencySpecifiedCondition;
		}
		
		@Override
		@RosettaAttribute("terminationCurrencyCondition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("terminationCurrencyCondition")
		public TerminationCurrencyConditionEnum getTerminationCurrencyCondition() {
			return terminationCurrencyCondition;
		}
		
		@Override
		public PartyOptionTerminationCurrency build() {
			return this;
		}
		
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder toBuilder() {
			PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder builder) {
			ofNullable(getBothAffectedTermCurrencyOption()).ifPresent(builder::setBothAffectedTermCurrencyOption);
			ofNullable(getTerminationCurrencySpecifiedCondition()).ifPresent(builder::setTerminationCurrencySpecifiedCondition);
			ofNullable(getTerminationCurrencyCondition()).ifPresent(builder::setTerminationCurrencyCondition);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyOptionTerminationCurrency _that = getType().cast(o);
		
			if (!Objects.equals(bothAffectedTermCurrencyOption, _that.getBothAffectedTermCurrencyOption())) return false;
			if (!Objects.equals(terminationCurrencySpecifiedCondition, _that.getTerminationCurrencySpecifiedCondition())) return false;
			if (!Objects.equals(terminationCurrencyCondition, _that.getTerminationCurrencyCondition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bothAffectedTermCurrencyOption != null ? bothAffectedTermCurrencyOption.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencySpecifiedCondition != null ? terminationCurrencySpecifiedCondition.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyCondition != null ? terminationCurrencyCondition.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyOptionTerminationCurrency {" +
				"bothAffectedTermCurrencyOption=" + this.bothAffectedTermCurrencyOption + ", " +
				"terminationCurrencySpecifiedCondition=" + this.terminationCurrencySpecifiedCondition + ", " +
				"terminationCurrencyCondition=" + this.terminationCurrencyCondition +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyOptionTerminationCurrency  ***********************/
	class PartyOptionTerminationCurrencyBuilderImpl implements PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder {
	
		protected String bothAffectedTermCurrencyOption;
		protected String terminationCurrencySpecifiedCondition;
		protected TerminationCurrencyConditionEnum terminationCurrencyCondition;
		
		@Override
		@RosettaAttribute("bothAffectedTermCurrencyOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bothAffectedTermCurrencyOption")
		public String getBothAffectedTermCurrencyOption() {
			return bothAffectedTermCurrencyOption;
		}
		
		@Override
		@RosettaAttribute("terminationCurrencySpecifiedCondition")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationCurrencySpecifiedCondition")
		public String getTerminationCurrencySpecifiedCondition() {
			return terminationCurrencySpecifiedCondition;
		}
		
		@Override
		@RosettaAttribute("terminationCurrencyCondition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("terminationCurrencyCondition")
		public TerminationCurrencyConditionEnum getTerminationCurrencyCondition() {
			return terminationCurrencyCondition;
		}
		
		@RosettaAttribute("bothAffectedTermCurrencyOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bothAffectedTermCurrencyOption")
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setBothAffectedTermCurrencyOption(String _bothAffectedTermCurrencyOption) {
			this.bothAffectedTermCurrencyOption = _bothAffectedTermCurrencyOption == null ? null : _bothAffectedTermCurrencyOption;
			return this;
		}
		
		@RosettaAttribute("terminationCurrencySpecifiedCondition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationCurrencySpecifiedCondition")
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setTerminationCurrencySpecifiedCondition(String _terminationCurrencySpecifiedCondition) {
			this.terminationCurrencySpecifiedCondition = _terminationCurrencySpecifiedCondition == null ? null : _terminationCurrencySpecifiedCondition;
			return this;
		}
		
		@RosettaAttribute("terminationCurrencyCondition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("terminationCurrencyCondition")
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setTerminationCurrencyCondition(TerminationCurrencyConditionEnum _terminationCurrencyCondition) {
			this.terminationCurrencyCondition = _terminationCurrencyCondition == null ? null : _terminationCurrencyCondition;
			return this;
		}
		
		@Override
		public PartyOptionTerminationCurrency build() {
			return new PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyImpl(this);
		}
		
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBothAffectedTermCurrencyOption()!=null) return true;
			if (getTerminationCurrencySpecifiedCondition()!=null) return true;
			if (getTerminationCurrencyCondition()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder o = (PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder) other;
			
			
			merger.mergeBasic(getBothAffectedTermCurrencyOption(), o.getBothAffectedTermCurrencyOption(), this::setBothAffectedTermCurrencyOption);
			merger.mergeBasic(getTerminationCurrencySpecifiedCondition(), o.getTerminationCurrencySpecifiedCondition(), this::setTerminationCurrencySpecifiedCondition);
			merger.mergeBasic(getTerminationCurrencyCondition(), o.getTerminationCurrencyCondition(), this::setTerminationCurrencyCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyOptionTerminationCurrency _that = getType().cast(o);
		
			if (!Objects.equals(bothAffectedTermCurrencyOption, _that.getBothAffectedTermCurrencyOption())) return false;
			if (!Objects.equals(terminationCurrencySpecifiedCondition, _that.getTerminationCurrencySpecifiedCondition())) return false;
			if (!Objects.equals(terminationCurrencyCondition, _that.getTerminationCurrencyCondition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bothAffectedTermCurrencyOption != null ? bothAffectedTermCurrencyOption.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencySpecifiedCondition != null ? terminationCurrencySpecifiedCondition.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyCondition != null ? terminationCurrencyCondition.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyOptionTerminationCurrencyBuilder {" +
				"bothAffectedTermCurrencyOption=" + this.bothAffectedTermCurrencyOption + ", " +
				"terminationCurrencySpecifiedCondition=" + this.terminationCurrencySpecifiedCondition + ", " +
				"terminationCurrencyCondition=" + this.terminationCurrencyCondition +
			'}';
		}
	}
}
