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
import fpml.consolidated.fpmlenum.TelephoneTypeEnum;
import fpml.consolidated.shared.meta.TelephoneNumberMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that represents a telephonic contact.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that represents a telephonic contact.
 *
 */
@RosettaDataType(value="TelephoneNumber", builder=TelephoneNumber.TelephoneNumberBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TelephoneNumber", model="fpml", builder=TelephoneNumber.TelephoneNumberBuilderImpl.class, version="2.1.1")
public interface TelephoneNumber extends RosettaModelObject {

	TelephoneNumberMeta metaData = new TelephoneNumberMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of telephone number (work, personal, mobile).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of telephone number (work, personal, mobile).
	 *
	 */
	TelephoneTypeEnum _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A telephonic contact.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A telephonic contact.
	 *
	 */
	String getNumber();

	/*********************** Build Methods  ***********************/
	TelephoneNumber build();
	
	TelephoneNumber.TelephoneNumberBuilder toBuilder();
	
	static TelephoneNumber.TelephoneNumberBuilder builder() {
		return new TelephoneNumber.TelephoneNumberBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TelephoneNumber> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TelephoneNumber> getType() {
		return TelephoneNumber.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("type"), TelephoneTypeEnum.class, _getType(), this);
		processor.processBasic(path.newSubPath("number"), String.class, getNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TelephoneNumberBuilder extends TelephoneNumber, RosettaModelObjectBuilder {
		TelephoneNumber.TelephoneNumberBuilder setType(TelephoneTypeEnum type);
		TelephoneNumber.TelephoneNumberBuilder setNumber(String number);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("type"), TelephoneTypeEnum.class, _getType(), this);
			processor.processBasic(path.newSubPath("number"), String.class, getNumber(), this);
		}
		

		TelephoneNumber.TelephoneNumberBuilder prune();
	}

	/*********************** Immutable Implementation of TelephoneNumber  ***********************/
	class TelephoneNumberImpl implements TelephoneNumber {
		private final TelephoneTypeEnum type;
		private final String number;
		
		protected TelephoneNumberImpl(TelephoneNumber.TelephoneNumberBuilder builder) {
			this.type = builder._getType();
			this.number = builder.getNumber();
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public TelephoneTypeEnum _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("number")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("number")
		public String getNumber() {
			return number;
		}
		
		@Override
		public TelephoneNumber build() {
			return this;
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder toBuilder() {
			TelephoneNumber.TelephoneNumberBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TelephoneNumber.TelephoneNumberBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getNumber()).ifPresent(builder::setNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TelephoneNumber _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(number, _that.getNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TelephoneNumber {" +
				"type=" + this.type + ", " +
				"number=" + this.number +
			'}';
		}
	}

	/*********************** Builder Implementation of TelephoneNumber  ***********************/
	class TelephoneNumberBuilderImpl implements TelephoneNumber.TelephoneNumberBuilder {
	
		protected TelephoneTypeEnum type;
		protected String number;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public TelephoneTypeEnum _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("number")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("number")
		public String getNumber() {
			return number;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder setType(TelephoneTypeEnum _type) {
			this.type = _type == null ? null : _type;
			return this;
		}
		
		@RosettaAttribute("number")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("number")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder setNumber(String _number) {
			this.number = _number == null ? null : _number;
			return this;
		}
		
		@Override
		public TelephoneNumber build() {
			return new TelephoneNumber.TelephoneNumberImpl(this);
		}
		
		@Override
		public TelephoneNumber.TelephoneNumberBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null) return true;
			if (getNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TelephoneNumber.TelephoneNumberBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TelephoneNumber.TelephoneNumberBuilder o = (TelephoneNumber.TelephoneNumberBuilder) other;
			
			
			merger.mergeBasic(_getType(), o._getType(), this::setType);
			merger.mergeBasic(getNumber(), o.getNumber(), this::setNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TelephoneNumber _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(number, _that.getNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TelephoneNumberBuilder {" +
				"type=" + this.type + ", " +
				"number=" + this.number +
			'}';
		}
	}
}
