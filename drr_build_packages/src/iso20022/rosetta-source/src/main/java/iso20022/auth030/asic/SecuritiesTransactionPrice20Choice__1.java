package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.SecuritiesTransactionPrice20Choice__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SecuritiesTransactionPrice20Choice__1", builder=SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecuritiesTransactionPrice20Choice__1", model="iso20022", builder=SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1BuilderImpl.class, version="${project.version}")
public interface SecuritiesTransactionPrice20Choice__1 extends RosettaModelObject {

	SecuritiesTransactionPrice20Choice__1Meta metaData = new SecuritiesTransactionPrice20Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	AmountAndDirection106__1 getMntryVal();
	BigDecimal getDcml();
	Integer getBsisPtSprd();

	/*********************** Build Methods  ***********************/
	SecuritiesTransactionPrice20Choice__1 build();
	
	SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder toBuilder();
	
	static SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder builder() {
		return new SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecuritiesTransactionPrice20Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecuritiesTransactionPrice20Choice__1> getType() {
		return SecuritiesTransactionPrice20Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mntryVal"), processor, AmountAndDirection106__1.class, getMntryVal());
		processor.processBasic(path.newSubPath("dcml"), BigDecimal.class, getDcml(), this);
		processor.processBasic(path.newSubPath("bsisPtSprd"), Integer.class, getBsisPtSprd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecuritiesTransactionPrice20Choice__1Builder extends SecuritiesTransactionPrice20Choice__1, RosettaModelObjectBuilder {
		AmountAndDirection106__1.AmountAndDirection106__1Builder getOrCreateMntryVal();
		@Override
		AmountAndDirection106__1.AmountAndDirection106__1Builder getMntryVal();
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder setMntryVal(AmountAndDirection106__1 mntryVal);
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder setDcml(BigDecimal dcml);
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder setBsisPtSprd(Integer bsisPtSprd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mntryVal"), processor, AmountAndDirection106__1.AmountAndDirection106__1Builder.class, getMntryVal());
			processor.processBasic(path.newSubPath("dcml"), BigDecimal.class, getDcml(), this);
			processor.processBasic(path.newSubPath("bsisPtSprd"), Integer.class, getBsisPtSprd(), this);
		}
		

		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of SecuritiesTransactionPrice20Choice__1  ***********************/
	class SecuritiesTransactionPrice20Choice__1Impl implements SecuritiesTransactionPrice20Choice__1 {
		private final AmountAndDirection106__1 mntryVal;
		private final BigDecimal dcml;
		private final Integer bsisPtSprd;
		
		protected SecuritiesTransactionPrice20Choice__1Impl(SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder builder) {
			this.mntryVal = ofNullable(builder.getMntryVal()).map(f->f.build()).orElse(null);
			this.dcml = builder.getDcml();
			this.bsisPtSprd = builder.getBsisPtSprd();
		}
		
		@Override
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mntryVal")
		public AmountAndDirection106__1 getMntryVal() {
			return mntryVal;
		}
		
		@Override
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dcml")
		public BigDecimal getDcml() {
			return dcml;
		}
		
		@Override
		@RosettaAttribute("bsisPtSprd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bsisPtSprd")
		public Integer getBsisPtSprd() {
			return bsisPtSprd;
		}
		
		@Override
		public SecuritiesTransactionPrice20Choice__1 build() {
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder toBuilder() {
			SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder builder) {
			ofNullable(getMntryVal()).ifPresent(builder::setMntryVal);
			ofNullable(getDcml()).ifPresent(builder::setDcml);
			ofNullable(getBsisPtSprd()).ifPresent(builder::setBsisPtSprd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice20Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(mntryVal, _that.getMntryVal())) return false;
			if (!Objects.equals(dcml, _that.getDcml())) return false;
			if (!Objects.equals(bsisPtSprd, _that.getBsisPtSprd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mntryVal != null ? mntryVal.hashCode() : 0);
			_result = 31 * _result + (dcml != null ? dcml.hashCode() : 0);
			_result = 31 * _result + (bsisPtSprd != null ? bsisPtSprd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice20Choice__1 {" +
				"mntryVal=" + this.mntryVal + ", " +
				"dcml=" + this.dcml + ", " +
				"bsisPtSprd=" + this.bsisPtSprd +
			'}';
		}
	}

	/*********************** Builder Implementation of SecuritiesTransactionPrice20Choice__1  ***********************/
	class SecuritiesTransactionPrice20Choice__1BuilderImpl implements SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder {
	
		protected AmountAndDirection106__1.AmountAndDirection106__1Builder mntryVal;
		protected BigDecimal dcml;
		protected Integer bsisPtSprd;
		
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
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dcml")
		public BigDecimal getDcml() {
			return dcml;
		}
		
		@Override
		@RosettaAttribute("bsisPtSprd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bsisPtSprd")
		public Integer getBsisPtSprd() {
			return bsisPtSprd;
		}
		
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mntryVal")
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder setMntryVal(AmountAndDirection106__1 _mntryVal) {
			this.mntryVal = _mntryVal == null ? null : _mntryVal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dcml")
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder setDcml(BigDecimal _dcml) {
			this.dcml = _dcml == null ? null : _dcml;
			return this;
		}
		
		@RosettaAttribute("bsisPtSprd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bsisPtSprd")
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder setBsisPtSprd(Integer _bsisPtSprd) {
			this.bsisPtSprd = _bsisPtSprd == null ? null : _bsisPtSprd;
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice20Choice__1 build() {
			return new SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Impl(this);
		}
		
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder prune() {
			if (mntryVal!=null && !mntryVal.prune().hasData()) mntryVal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMntryVal()!=null && getMntryVal().hasData()) return true;
			if (getDcml()!=null) return true;
			if (getBsisPtSprd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder o = (SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder) other;
			
			merger.mergeRosetta(getMntryVal(), o.getMntryVal(), this::setMntryVal);
			
			merger.mergeBasic(getDcml(), o.getDcml(), this::setDcml);
			merger.mergeBasic(getBsisPtSprd(), o.getBsisPtSprd(), this::setBsisPtSprd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice20Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(mntryVal, _that.getMntryVal())) return false;
			if (!Objects.equals(dcml, _that.getDcml())) return false;
			if (!Objects.equals(bsisPtSprd, _that.getBsisPtSprd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mntryVal != null ? mntryVal.hashCode() : 0);
			_result = 31 * _result + (dcml != null ? dcml.hashCode() : 0);
			_result = 31 * _result + (bsisPtSprd != null ? bsisPtSprd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice20Choice__1Builder {" +
				"mntryVal=" + this.mntryVal + ", " +
				"dcml=" + this.dcml + ", " +
				"bsisPtSprd=" + this.bsisPtSprd +
			'}';
		}
	}
}
