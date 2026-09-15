package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.SecuritiesTransactionPrice5Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Price with notation.
 * @version ${project.version}
 */
@RosettaDataType(value="SecuritiesTransactionPrice5", builder=SecuritiesTransactionPrice5.SecuritiesTransactionPrice5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecuritiesTransactionPrice5", model="iso20022", builder=SecuritiesTransactionPrice5.SecuritiesTransactionPrice5BuilderImpl.class, version="${project.version}")
public interface SecuritiesTransactionPrice5 extends RosettaModelObject {

	SecuritiesTransactionPrice5Meta metaData = new SecuritiesTransactionPrice5Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Value of the price.
	 */
	BigDecimal getVal();
	/**
	 * Notation of the price.
	 */
	String getTp();

	/*********************** Build Methods  ***********************/
	SecuritiesTransactionPrice5 build();
	
	SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder toBuilder();
	
	static SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder builder() {
		return new SecuritiesTransactionPrice5.SecuritiesTransactionPrice5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecuritiesTransactionPrice5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecuritiesTransactionPrice5> getType() {
		return SecuritiesTransactionPrice5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("val"), BigDecimal.class, getVal(), this);
		processor.processBasic(path.newSubPath("tp"), String.class, getTp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecuritiesTransactionPrice5Builder extends SecuritiesTransactionPrice5, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder setVal(BigDecimal val);
		SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder setTp(String tp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("val"), BigDecimal.class, getVal(), this);
			processor.processBasic(path.newSubPath("tp"), String.class, getTp(), this);
		}
		

		SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder prune();
	}

	/*********************** Immutable Implementation of SecuritiesTransactionPrice5  ***********************/
	class SecuritiesTransactionPrice5Impl implements SecuritiesTransactionPrice5 {
		private final BigDecimal val;
		private final String tp;
		
		protected SecuritiesTransactionPrice5Impl(SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder builder) {
			this.val = builder.getVal();
			this.tp = builder.getTp();
		}
		
		@Override
		@RosettaAttribute("val")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("val")
		public BigDecimal getVal() {
			return val;
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tp")
		public String getTp() {
			return tp;
		}
		
		@Override
		public SecuritiesTransactionPrice5 build() {
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder toBuilder() {
			SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder builder) {
			ofNullable(getVal()).ifPresent(builder::setVal);
			ofNullable(getTp()).ifPresent(builder::setTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice5 _that = getType().cast(o);
		
			if (!Objects.equals(val, _that.getVal())) return false;
			if (!Objects.equals(tp, _that.getTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (val != null ? val.hashCode() : 0);
			_result = 31 * _result + (tp != null ? tp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice5 {" +
				"val=" + this.val + ", " +
				"tp=" + this.tp +
			'}';
		}
	}

	/*********************** Builder Implementation of SecuritiesTransactionPrice5  ***********************/
	class SecuritiesTransactionPrice5BuilderImpl implements SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder {
	
		protected BigDecimal val;
		protected String tp;
		
		@Override
		@RosettaAttribute("val")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("val")
		public BigDecimal getVal() {
			return val;
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tp")
		public String getTp() {
			return tp;
		}
		
		@RosettaAttribute("val")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("val")
		@Override
		public SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder setVal(BigDecimal _val) {
			this.val = _val == null ? null : _val;
			return this;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tp")
		@Override
		public SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder setTp(String _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice5 build() {
			return new SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Impl(this);
		}
		
		@Override
		public SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVal()!=null) return true;
			if (getTp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder o = (SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder) other;
			
			
			merger.mergeBasic(getVal(), o.getVal(), this::setVal);
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice5 _that = getType().cast(o);
		
			if (!Objects.equals(val, _that.getVal())) return false;
			if (!Objects.equals(tp, _that.getTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (val != null ? val.hashCode() : 0);
			_result = 31 * _result + (tp != null ? tp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice5Builder {" +
				"val=" + this.val + ", " +
				"tp=" + this.tp +
			'}';
		}
	}
}
