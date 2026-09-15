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
import iso20022.auth030.esma.meta.SecuritiesTransactionPrice17Choice__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice to define the price of the securities transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="SecuritiesTransactionPrice17Choice__1", builder=SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecuritiesTransactionPrice17Choice__1", model="iso20022", builder=SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1BuilderImpl.class, version="${project.version}")
public interface SecuritiesTransactionPrice17Choice__1 extends RosettaModelObject {

	SecuritiesTransactionPrice17Choice__1Meta metaData = new SecuritiesTransactionPrice17Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that price is expressed as a monetary value.
	 */
	AmountAndDirection106__1 getMntryVal();
	/**
	 * Indicates that price is expressed as a rate, that is a percentage.
	 */
	BigDecimal getPctg();

	/*********************** Build Methods  ***********************/
	SecuritiesTransactionPrice17Choice__1 build();
	
	SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder toBuilder();
	
	static SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder builder() {
		return new SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecuritiesTransactionPrice17Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecuritiesTransactionPrice17Choice__1> getType() {
		return SecuritiesTransactionPrice17Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mntryVal"), processor, AmountAndDirection106__1.class, getMntryVal());
		processor.processBasic(path.newSubPath("pctg"), BigDecimal.class, getPctg(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecuritiesTransactionPrice17Choice__1Builder extends SecuritiesTransactionPrice17Choice__1, RosettaModelObjectBuilder {
		AmountAndDirection106__1.AmountAndDirection106__1Builder getOrCreateMntryVal();
		@Override
		AmountAndDirection106__1.AmountAndDirection106__1Builder getMntryVal();
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder setMntryVal(AmountAndDirection106__1 mntryVal);
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder setPctg(BigDecimal pctg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mntryVal"), processor, AmountAndDirection106__1.AmountAndDirection106__1Builder.class, getMntryVal());
			processor.processBasic(path.newSubPath("pctg"), BigDecimal.class, getPctg(), this);
		}
		

		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of SecuritiesTransactionPrice17Choice__1  ***********************/
	class SecuritiesTransactionPrice17Choice__1Impl implements SecuritiesTransactionPrice17Choice__1 {
		private final AmountAndDirection106__1 mntryVal;
		private final BigDecimal pctg;
		
		protected SecuritiesTransactionPrice17Choice__1Impl(SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder builder) {
			this.mntryVal = ofNullable(builder.getMntryVal()).map(f->f.build()).orElse(null);
			this.pctg = builder.getPctg();
		}
		
		@Override
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mntryVal")
		public AmountAndDirection106__1 getMntryVal() {
			return mntryVal;
		}
		
		@Override
		@RosettaAttribute("pctg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pctg")
		public BigDecimal getPctg() {
			return pctg;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__1 build() {
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder toBuilder() {
			SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder builder) {
			ofNullable(getMntryVal()).ifPresent(builder::setMntryVal);
			ofNullable(getPctg()).ifPresent(builder::setPctg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice17Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(mntryVal, _that.getMntryVal())) return false;
			if (!Objects.equals(pctg, _that.getPctg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mntryVal != null ? mntryVal.hashCode() : 0);
			_result = 31 * _result + (pctg != null ? pctg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice17Choice__1 {" +
				"mntryVal=" + this.mntryVal + ", " +
				"pctg=" + this.pctg +
			'}';
		}
	}

	/*********************** Builder Implementation of SecuritiesTransactionPrice17Choice__1  ***********************/
	class SecuritiesTransactionPrice17Choice__1BuilderImpl implements SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder {
	
		protected AmountAndDirection106__1.AmountAndDirection106__1Builder mntryVal;
		protected BigDecimal pctg;
		
		@Override
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mntryVal")
		public AmountAndDirection106__1.AmountAndDirection106__1Builder getMntryVal() {
			return mntryVal;
		}
		
		@Override
		public AmountAndDirection106__1.AmountAndDirection106__1Builder getOrCreateMntryVal() {
			AmountAndDirection106__1.AmountAndDirection106__1Builder result;
			if (mntryVal!=null) {
				result = mntryVal;
			}
			else {
				result = mntryVal = AmountAndDirection106__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pctg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pctg")
		public BigDecimal getPctg() {
			return pctg;
		}
		
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mntryVal")
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder setMntryVal(AmountAndDirection106__1 _mntryVal) {
			this.mntryVal = _mntryVal == null ? null : _mntryVal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pctg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pctg")
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder setPctg(BigDecimal _pctg) {
			this.pctg = _pctg == null ? null : _pctg;
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__1 build() {
			return new SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Impl(this);
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder prune() {
			if (mntryVal!=null && !mntryVal.prune().hasData()) mntryVal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMntryVal()!=null && getMntryVal().hasData()) return true;
			if (getPctg()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder o = (SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder) other;
			
			merger.mergeRosetta(getMntryVal(), o.getMntryVal(), this::setMntryVal);
			
			merger.mergeBasic(getPctg(), o.getPctg(), this::setPctg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice17Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(mntryVal, _that.getMntryVal())) return false;
			if (!Objects.equals(pctg, _that.getPctg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mntryVal != null ? mntryVal.hashCode() : 0);
			_result = 31 * _result + (pctg != null ? pctg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice17Choice__1Builder {" +
				"mntryVal=" + this.mntryVal + ", " +
				"pctg=" + this.pctg +
			'}';
		}
	}
}
