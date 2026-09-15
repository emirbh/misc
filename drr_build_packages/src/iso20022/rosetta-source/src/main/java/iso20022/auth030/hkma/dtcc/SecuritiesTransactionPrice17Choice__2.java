package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.SecuritiesTransactionPrice17Choice__2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice to define the price of the securities transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="SecuritiesTransactionPrice17Choice__2", builder=SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecuritiesTransactionPrice17Choice__2", model="iso20022", builder=SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2BuilderImpl.class, version="${project.version}")
public interface SecuritiesTransactionPrice17Choice__2 extends RosettaModelObject {

	SecuritiesTransactionPrice17Choice__2Meta metaData = new SecuritiesTransactionPrice17Choice__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that price is expressed as a monetary value.
	 */
	AmountAndDirection106__2 getMntryVal();
	BigDecimal getDcml();

	/*********************** Build Methods  ***********************/
	SecuritiesTransactionPrice17Choice__2 build();
	
	SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder toBuilder();
	
	static SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder builder() {
		return new SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecuritiesTransactionPrice17Choice__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecuritiesTransactionPrice17Choice__2> getType() {
		return SecuritiesTransactionPrice17Choice__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mntryVal"), processor, AmountAndDirection106__2.class, getMntryVal());
		processor.processBasic(path.newSubPath("dcml"), BigDecimal.class, getDcml(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecuritiesTransactionPrice17Choice__2Builder extends SecuritiesTransactionPrice17Choice__2, RosettaModelObjectBuilder {
		AmountAndDirection106__2.AmountAndDirection106__2Builder getOrCreateMntryVal();
		@Override
		AmountAndDirection106__2.AmountAndDirection106__2Builder getMntryVal();
		SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder setMntryVal(AmountAndDirection106__2 mntryVal);
		SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder setDcml(BigDecimal dcml);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mntryVal"), processor, AmountAndDirection106__2.AmountAndDirection106__2Builder.class, getMntryVal());
			processor.processBasic(path.newSubPath("dcml"), BigDecimal.class, getDcml(), this);
		}
		

		SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder prune();
	}

	/*********************** Immutable Implementation of SecuritiesTransactionPrice17Choice__2  ***********************/
	class SecuritiesTransactionPrice17Choice__2Impl implements SecuritiesTransactionPrice17Choice__2 {
		private final AmountAndDirection106__2 mntryVal;
		private final BigDecimal dcml;
		
		protected SecuritiesTransactionPrice17Choice__2Impl(SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder builder) {
			this.mntryVal = ofNullable(builder.getMntryVal()).map(f->f.build()).orElse(null);
			this.dcml = builder.getDcml();
		}
		
		@Override
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mntryVal")
		public AmountAndDirection106__2 getMntryVal() {
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
		public SecuritiesTransactionPrice17Choice__2 build() {
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder toBuilder() {
			SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder builder) {
			ofNullable(getMntryVal()).ifPresent(builder::setMntryVal);
			ofNullable(getDcml()).ifPresent(builder::setDcml);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice17Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(mntryVal, _that.getMntryVal())) return false;
			if (!Objects.equals(dcml, _that.getDcml())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mntryVal != null ? mntryVal.hashCode() : 0);
			_result = 31 * _result + (dcml != null ? dcml.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice17Choice__2 {" +
				"mntryVal=" + this.mntryVal + ", " +
				"dcml=" + this.dcml +
			'}';
		}
	}

	/*********************** Builder Implementation of SecuritiesTransactionPrice17Choice__2  ***********************/
	class SecuritiesTransactionPrice17Choice__2BuilderImpl implements SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder {
	
		protected AmountAndDirection106__2.AmountAndDirection106__2Builder mntryVal;
		protected BigDecimal dcml;
		
		@Override
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mntryVal")
		public AmountAndDirection106__2.AmountAndDirection106__2Builder getMntryVal() {
			return mntryVal;
		}
		
		@Override
		public AmountAndDirection106__2.AmountAndDirection106__2Builder getOrCreateMntryVal() {
			AmountAndDirection106__2.AmountAndDirection106__2Builder result;
			if (mntryVal!=null) {
				result = mntryVal;
			}
			else {
				result = mntryVal = AmountAndDirection106__2.builder();
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
		
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mntryVal")
		@Override
		public SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder setMntryVal(AmountAndDirection106__2 _mntryVal) {
			this.mntryVal = _mntryVal == null ? null : _mntryVal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dcml")
		@Override
		public SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder setDcml(BigDecimal _dcml) {
			this.dcml = _dcml == null ? null : _dcml;
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__2 build() {
			return new SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Impl(this);
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder prune() {
			if (mntryVal!=null && !mntryVal.prune().hasData()) mntryVal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMntryVal()!=null && getMntryVal().hasData()) return true;
			if (getDcml()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder o = (SecuritiesTransactionPrice17Choice__2.SecuritiesTransactionPrice17Choice__2Builder) other;
			
			merger.mergeRosetta(getMntryVal(), o.getMntryVal(), this::setMntryVal);
			
			merger.mergeBasic(getDcml(), o.getDcml(), this::setDcml);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice17Choice__2 _that = getType().cast(o);
		
			if (!Objects.equals(mntryVal, _that.getMntryVal())) return false;
			if (!Objects.equals(dcml, _that.getDcml())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mntryVal != null ? mntryVal.hashCode() : 0);
			_result = 31 * _result + (dcml != null ? dcml.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice17Choice__2Builder {" +
				"mntryVal=" + this.mntryVal + ", " +
				"dcml=" + this.dcml +
			'}';
		}
	}
}
