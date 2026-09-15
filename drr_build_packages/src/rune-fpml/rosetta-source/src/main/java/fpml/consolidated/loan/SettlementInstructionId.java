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
import fpml.consolidated.loan.meta.SettlementInstructionIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a cash settlement details identifier and qualifying scheme
 *
 */
@RosettaDataType(value="SettlementInstructionId", builder=SettlementInstructionId.SettlementInstructionIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementInstructionId", model="fpml", builder=SettlementInstructionId.SettlementInstructionIdBuilderImpl.class, version="2.1.1")
public interface SettlementInstructionId extends RosettaModelObject {

	SettlementInstructionIdMeta metaData = new SettlementInstructionIdMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getSettlementInstructionIdScheme();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	SettlementInstructionId build();
	
	SettlementInstructionId.SettlementInstructionIdBuilder toBuilder();
	
	static SettlementInstructionId.SettlementInstructionIdBuilder builder() {
		return new SettlementInstructionId.SettlementInstructionIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementInstructionId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementInstructionId> getType() {
		return SettlementInstructionId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("settlementInstructionIdScheme"), String.class, getSettlementInstructionIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementInstructionIdBuilder extends SettlementInstructionId, RosettaModelObjectBuilder {
		SettlementInstructionId.SettlementInstructionIdBuilder setValue(String value);
		SettlementInstructionId.SettlementInstructionIdBuilder setSettlementInstructionIdScheme(String settlementInstructionIdScheme);
		SettlementInstructionId.SettlementInstructionIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("settlementInstructionIdScheme"), String.class, getSettlementInstructionIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SettlementInstructionId.SettlementInstructionIdBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementInstructionId  ***********************/
	class SettlementInstructionIdImpl implements SettlementInstructionId {
		private final String value;
		private final String settlementInstructionIdScheme;
		private final String id;
		
		protected SettlementInstructionIdImpl(SettlementInstructionId.SettlementInstructionIdBuilder builder) {
			this.value = builder.getValue();
			this.settlementInstructionIdScheme = builder.getSettlementInstructionIdScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settlementInstructionIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementInstructionIdScheme")
		public String getSettlementInstructionIdScheme() {
			return settlementInstructionIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public SettlementInstructionId build() {
			return this;
		}
		
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder toBuilder() {
			SettlementInstructionId.SettlementInstructionIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementInstructionId.SettlementInstructionIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSettlementInstructionIdScheme()).ifPresent(builder::setSettlementInstructionIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInstructionId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementInstructionIdScheme, _that.getSettlementInstructionIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementInstructionIdScheme != null ? settlementInstructionIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInstructionId {" +
				"value=" + this.value + ", " +
				"settlementInstructionIdScheme=" + this.settlementInstructionIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementInstructionId  ***********************/
	class SettlementInstructionIdBuilderImpl implements SettlementInstructionId.SettlementInstructionIdBuilder {
	
		protected String value;
		protected String settlementInstructionIdScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settlementInstructionIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementInstructionIdScheme")
		public String getSettlementInstructionIdScheme() {
			return settlementInstructionIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("settlementInstructionIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementInstructionIdScheme")
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder setSettlementInstructionIdScheme(String _settlementInstructionIdScheme) {
			this.settlementInstructionIdScheme = _settlementInstructionIdScheme == null ? null : _settlementInstructionIdScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public SettlementInstructionId build() {
			return new SettlementInstructionId.SettlementInstructionIdImpl(this);
		}
		
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSettlementInstructionIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementInstructionId.SettlementInstructionIdBuilder o = (SettlementInstructionId.SettlementInstructionIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSettlementInstructionIdScheme(), o.getSettlementInstructionIdScheme(), this::setSettlementInstructionIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementInstructionId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementInstructionIdScheme, _that.getSettlementInstructionIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementInstructionIdScheme != null ? settlementInstructionIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementInstructionIdBuilder {" +
				"value=" + this.value + ", " +
				"settlementInstructionIdScheme=" + this.settlementInstructionIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
