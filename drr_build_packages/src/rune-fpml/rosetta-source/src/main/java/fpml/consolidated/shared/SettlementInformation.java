package fpml.consolidated.shared;

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
import fpml.consolidated.fpmlenum.StandardSettlementStyleEnum;
import fpml.consolidated.shared.meta.SettlementInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that represents the choice of methods for settling a potential currency payment resulting from a trade: by means of a standard settlement instruction, by netting it out with other payments, or with an explicit settlement instruction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that represents the choice of methods for settling a potential currency payment resulting from a trade: by means of a standard settlement instruction, by netting it out with other payments, or with an explicit settlement instruction.
 *
 */
@RosettaDataType(value="SettlementInformation", builder=SettlementInformation.SettlementInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementInformation", model="fpml", builder=SettlementInformation.SettlementInformationBuilderImpl.class, version="2.1.1")
public interface SettlementInformation extends RosettaModelObject {

	SettlementInformationMeta metaData = new SettlementInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element used to describe how a trade will settle. This defines a scheme and is used for identifying trades that are identified as settling standard and/or flagged for settlement netting.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element used to describe how a trade will settle. This defines a scheme and is used for identifying trades that are identified as settling standard and/or flagged for settlement netting.
	 *
	 */
	StandardSettlementStyleEnum getStandardSettlementStyle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An explicit specification of how a currency payment is to be made, when the payment is not netted and the route is other than the recipient's standard settlement instruction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An explicit specification of how a currency payment is to be made, when the payment is not netted and the route is other than the recipient's standard settlement instruction.
	 *
	 */
	SettlementInstruction getSettlementInstruction();

	/*********************** Build Methods  ***********************/
	SettlementInformation build();
	
	SettlementInformation.SettlementInformationBuilder toBuilder();
	
	static SettlementInformation.SettlementInformationBuilder builder() {
		return new SettlementInformation.SettlementInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementInformation> getType() {
		return SettlementInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardSettlementStyle"), StandardSettlementStyleEnum.class, getStandardSettlementStyle(), this);
		processRosetta(path.newSubPath("settlementInstruction"), processor, SettlementInstruction.class, getSettlementInstruction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementInformationBuilder extends SettlementInformation, RosettaModelObjectBuilder {
		SettlementInstruction.SettlementInstructionBuilder getOrCreateSettlementInstruction();
		@Override
		SettlementInstruction.SettlementInstructionBuilder getSettlementInstruction();
		SettlementInformation.SettlementInformationBuilder setStandardSettlementStyle(StandardSettlementStyleEnum standardSettlementStyle);
		SettlementInformation.SettlementInformationBuilder setSettlementInstruction(SettlementInstruction settlementInstruction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardSettlementStyle"), StandardSettlementStyleEnum.class, getStandardSettlementStyle(), this);
			processRosetta(path.newSubPath("settlementInstruction"), processor, SettlementInstruction.SettlementInstructionBuilder.class, getSettlementInstruction());
		}
		

		SettlementInformation.SettlementInformationBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementInformation  ***********************/
	class SettlementInformationImpl implements SettlementInformation {
		private final StandardSettlementStyleEnum standardSettlementStyle;
		private final SettlementInstruction settlementInstruction;
		
		protected SettlementInformationImpl(SettlementInformation.SettlementInformationBuilder builder) {
			this.standardSettlementStyle = builder.getStandardSettlementStyle();
			this.settlementInstruction = ofNullable(builder.getSettlementInstruction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("standardSettlementStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardSettlementStyle")
		public StandardSettlementStyleEnum getStandardSettlementStyle() {
			return standardSettlementStyle;
		}
		
		@Override
		@RosettaAttribute("settlementInstruction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInstruction")
		public SettlementInstruction getSettlementInstruction() {
			return settlementInstruction;
		}
		
		@Override
		public SettlementInformation build() {
			return this;
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder toBuilder() {
			SettlementInformation.SettlementInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementInformation.SettlementInformationBuilder builder) {
			ofNullable(getStandardSettlementStyle()).ifPresent(builder::setStandardSettlementStyle);
			ofNullable(getSettlementInstruction()).ifPresent(builder::setSettlementInstruction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInformation _that = getType().cast(o);
		
			if (!Objects.equals(standardSettlementStyle, _that.getStandardSettlementStyle())) return false;
			if (!Objects.equals(settlementInstruction, _that.getSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardSettlementStyle != null ? standardSettlementStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementInstruction != null ? settlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInformation {" +
				"standardSettlementStyle=" + this.standardSettlementStyle + ", " +
				"settlementInstruction=" + this.settlementInstruction +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementInformation  ***********************/
	class SettlementInformationBuilderImpl implements SettlementInformation.SettlementInformationBuilder {
	
		protected StandardSettlementStyleEnum standardSettlementStyle;
		protected SettlementInstruction.SettlementInstructionBuilder settlementInstruction;
		
		@Override
		@RosettaAttribute("standardSettlementStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardSettlementStyle")
		public StandardSettlementStyleEnum getStandardSettlementStyle() {
			return standardSettlementStyle;
		}
		
		@Override
		@RosettaAttribute("settlementInstruction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInstruction")
		public SettlementInstruction.SettlementInstructionBuilder getSettlementInstruction() {
			return settlementInstruction;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder getOrCreateSettlementInstruction() {
			SettlementInstruction.SettlementInstructionBuilder result;
			if (settlementInstruction!=null) {
				result = settlementInstruction;
			}
			else {
				result = settlementInstruction = SettlementInstruction.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("standardSettlementStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("standardSettlementStyle")
		@Override
		public SettlementInformation.SettlementInformationBuilder setStandardSettlementStyle(StandardSettlementStyleEnum _standardSettlementStyle) {
			this.standardSettlementStyle = _standardSettlementStyle == null ? null : _standardSettlementStyle;
			return this;
		}
		
		@RosettaAttribute("settlementInstruction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementInstruction")
		@Override
		public SettlementInformation.SettlementInformationBuilder setSettlementInstruction(SettlementInstruction _settlementInstruction) {
			this.settlementInstruction = _settlementInstruction == null ? null : _settlementInstruction.toBuilder();
			return this;
		}
		
		@Override
		public SettlementInformation build() {
			return new SettlementInformation.SettlementInformationImpl(this);
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInformation.SettlementInformationBuilder prune() {
			if (settlementInstruction!=null && !settlementInstruction.prune().hasData()) settlementInstruction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardSettlementStyle()!=null) return true;
			if (getSettlementInstruction()!=null && getSettlementInstruction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInformation.SettlementInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementInformation.SettlementInformationBuilder o = (SettlementInformation.SettlementInformationBuilder) other;
			
			merger.mergeRosetta(getSettlementInstruction(), o.getSettlementInstruction(), this::setSettlementInstruction);
			
			merger.mergeBasic(getStandardSettlementStyle(), o.getStandardSettlementStyle(), this::setStandardSettlementStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInformation _that = getType().cast(o);
		
			if (!Objects.equals(standardSettlementStyle, _that.getStandardSettlementStyle())) return false;
			if (!Objects.equals(settlementInstruction, _that.getSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardSettlementStyle != null ? standardSettlementStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementInstruction != null ? settlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInformationBuilder {" +
				"standardSettlementStyle=" + this.standardSettlementStyle + ", " +
				"settlementInstruction=" + this.settlementInstruction +
			'}';
		}
	}
}
