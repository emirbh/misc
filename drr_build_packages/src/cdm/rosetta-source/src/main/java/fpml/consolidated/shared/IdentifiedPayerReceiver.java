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
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
import fpml.consolidated.shared.meta.IdentifiedPayerReceiverMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type extending the PayerReceiverEnum type wih an id attribute.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type extending the PayerReceiverEnum type wih an id attribute.
 *
 */
@RosettaDataType(value="IdentifiedPayerReceiver", builder=IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IdentifiedPayerReceiver", model="fpml", builder=IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilderImpl.class, version="2.1.1")
public interface IdentifiedPayerReceiver extends RosettaModelObject {

	IdentifiedPayerReceiverMeta metaData = new IdentifiedPayerReceiverMeta();

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
	PayerReceiverEnum getValue();
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
	String getId();

	/*********************** Build Methods  ***********************/
	IdentifiedPayerReceiver build();
	
	IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder toBuilder();
	
	static IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder builder() {
		return new IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedPayerReceiver> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IdentifiedPayerReceiver> getType() {
		return IdentifiedPayerReceiver.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), PayerReceiverEnum.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedPayerReceiverBuilder extends IdentifiedPayerReceiver, RosettaModelObjectBuilder {
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder setValue(PayerReceiverEnum value);
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), PayerReceiverEnum.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedPayerReceiver  ***********************/
	class IdentifiedPayerReceiverImpl implements IdentifiedPayerReceiver {
		private final PayerReceiverEnum value;
		private final String id;
		
		protected IdentifiedPayerReceiverImpl(IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public PayerReceiverEnum getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public IdentifiedPayerReceiver build() {
			return this;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder toBuilder() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedPayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedPayerReceiver {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of IdentifiedPayerReceiver  ***********************/
	class IdentifiedPayerReceiverBuilderImpl implements IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder {
	
		protected PayerReceiverEnum value;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public PayerReceiverEnum getValue() {
			return value;
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
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder setValue(PayerReceiverEnum _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public IdentifiedPayerReceiver build() {
			return new IdentifiedPayerReceiver.IdentifiedPayerReceiverImpl(this);
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder o = (IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedPayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedPayerReceiverBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
