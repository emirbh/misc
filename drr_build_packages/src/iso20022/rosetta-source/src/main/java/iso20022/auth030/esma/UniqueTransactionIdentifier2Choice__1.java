package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.UniqueTransactionIdentifier2Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Element is a choice between a standard identifier and a proprietary code.
 * @version ${project.version}
 */
@RosettaDataType(value="UniqueTransactionIdentifier2Choice__1", builder=UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="UniqueTransactionIdentifier2Choice__1", model="iso20022", builder=UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1BuilderImpl.class, version="${project.version}")
public interface UniqueTransactionIdentifier2Choice__1 extends RosettaModelObject {

	UniqueTransactionIdentifier2Choice__1Meta metaData = new UniqueTransactionIdentifier2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique trade identifier (UTI) as agreed with the counterparty.
	 */
	String getUnqTxIdr();

	/*********************** Build Methods  ***********************/
	UniqueTransactionIdentifier2Choice__1 build();
	
	UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder toBuilder();
	
	static UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder builder() {
		return new UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UniqueTransactionIdentifier2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UniqueTransactionIdentifier2Choice__1> getType() {
		return UniqueTransactionIdentifier2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unqTxIdr"), String.class, getUnqTxIdr(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UniqueTransactionIdentifier2Choice__1Builder extends UniqueTransactionIdentifier2Choice__1, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder setUnqTxIdr(String unqTxIdr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unqTxIdr"), String.class, getUnqTxIdr(), this);
		}
		

		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of UniqueTransactionIdentifier2Choice__1  ***********************/
	class UniqueTransactionIdentifier2Choice__1Impl implements UniqueTransactionIdentifier2Choice__1 {
		private final String unqTxIdr;
		
		protected UniqueTransactionIdentifier2Choice__1Impl(UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder builder) {
			this.unqTxIdr = builder.getUnqTxIdr();
		}
		
		@Override
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("unqTxIdr")
		public String getUnqTxIdr() {
			return unqTxIdr;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1 build() {
			return this;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder toBuilder() {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder builder) {
			ofNullable(getUnqTxIdr()).ifPresent(builder::setUnqTxIdr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UniqueTransactionIdentifier2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(unqTxIdr, _that.getUnqTxIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqTxIdr != null ? unqTxIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UniqueTransactionIdentifier2Choice__1 {" +
				"unqTxIdr=" + this.unqTxIdr +
			'}';
		}
	}

	/*********************** Builder Implementation of UniqueTransactionIdentifier2Choice__1  ***********************/
	class UniqueTransactionIdentifier2Choice__1BuilderImpl implements UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder {
	
		protected String unqTxIdr;
		
		@Override
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("unqTxIdr")
		public String getUnqTxIdr() {
			return unqTxIdr;
		}
		
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("unqTxIdr")
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder setUnqTxIdr(String _unqTxIdr) {
			this.unqTxIdr = _unqTxIdr == null ? null : _unqTxIdr;
			return this;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1 build() {
			return new UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Impl(this);
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnqTxIdr()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder o = (UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder) other;
			
			
			merger.mergeBasic(getUnqTxIdr(), o.getUnqTxIdr(), this::setUnqTxIdr);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UniqueTransactionIdentifier2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(unqTxIdr, _that.getUnqTxIdr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqTxIdr != null ? unqTxIdr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UniqueTransactionIdentifier2Choice__1Builder {" +
				"unqTxIdr=" + this.unqTxIdr +
			'}';
		}
	}
}
