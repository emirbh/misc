package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.Package4__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Combination of two or more transactions that are reported separately but that are negotiated together as the product of a single economic agreement.
 * @version ${project.version}
 */
@RosettaDataType(value="Package4__1", builder=Package4__1.Package4__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Package4__1", model="iso20022", builder=Package4__1.Package4__1BuilderImpl.class, version="${project.version}")
public interface Package4__1 extends RosettaModelObject {

	Package4__1Meta metaData = new Package4__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the identifier determined by the reporting counterparty to connect: - two or more transactions that are reported separately but that are negotiated together as the product of a single economic agreement, - or two or more reports pertaining to the same transaction whenever jurisdictional reporting requirement does not allow the transaction to be reported with a single report to TRs.  Usage: Where the package identifier is not known when a new transaction is reported, the package identifier is updated as it becomes available.
	 */
	String getCmplxTradId();
	/**
	 * Identifier which is used to link the near leg and far leg of an FX swap per current industry practice. This identifier could distingish FX swap from other packaged transactions identified by ComplexTradeIdentification.
	 */
	String getFxSwpLkId();
	/**
	 * Indicates the traded price of the entire package in which the reported derivative transaction is a component.
	 */
	SecuritiesTransactionPrice17Choice__1 getPric();
	/**
	 * Indicates the traded price (expressed as a difference between two reference prices) of the entire package in which the reported derivative transaction is a component.
	 */
	SecuritiesTransactionPrice20Choice__1 getSprd();

	/*********************** Build Methods  ***********************/
	Package4__1 build();
	
	Package4__1.Package4__1Builder toBuilder();
	
	static Package4__1.Package4__1Builder builder() {
		return new Package4__1.Package4__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Package4__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Package4__1> getType() {
		return Package4__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cmplxTradId"), String.class, getCmplxTradId(), this);
		processor.processBasic(path.newSubPath("fxSwpLkId"), String.class, getFxSwpLkId(), this);
		processRosetta(path.newSubPath("pric"), processor, SecuritiesTransactionPrice17Choice__1.class, getPric());
		processRosetta(path.newSubPath("sprd"), processor, SecuritiesTransactionPrice20Choice__1.class, getSprd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface Package4__1Builder extends Package4__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreatePric();
		@Override
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getPric();
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getOrCreateSprd();
		@Override
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getSprd();
		Package4__1.Package4__1Builder setCmplxTradId(String cmplxTradId);
		Package4__1.Package4__1Builder setFxSwpLkId(String fxSwpLkId);
		Package4__1.Package4__1Builder setPric(SecuritiesTransactionPrice17Choice__1 pric);
		Package4__1.Package4__1Builder setSprd(SecuritiesTransactionPrice20Choice__1 sprd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cmplxTradId"), String.class, getCmplxTradId(), this);
			processor.processBasic(path.newSubPath("fxSwpLkId"), String.class, getFxSwpLkId(), this);
			processRosetta(path.newSubPath("pric"), processor, SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder.class, getPric());
			processRosetta(path.newSubPath("sprd"), processor, SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder.class, getSprd());
		}
		

		Package4__1.Package4__1Builder prune();
	}

	/*********************** Immutable Implementation of Package4__1  ***********************/
	class Package4__1Impl implements Package4__1 {
		private final String cmplxTradId;
		private final String fxSwpLkId;
		private final SecuritiesTransactionPrice17Choice__1 pric;
		private final SecuritiesTransactionPrice20Choice__1 sprd;
		
		protected Package4__1Impl(Package4__1.Package4__1Builder builder) {
			this.cmplxTradId = builder.getCmplxTradId();
			this.fxSwpLkId = builder.getFxSwpLkId();
			this.pric = ofNullable(builder.getPric()).map(f->f.build()).orElse(null);
			this.sprd = ofNullable(builder.getSprd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cmplxTradId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cmplxTradId")
		public String getCmplxTradId() {
			return cmplxTradId;
		}
		
		@Override
		@RosettaAttribute("fxSwpLkId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxSwpLkId")
		public String getFxSwpLkId() {
			return fxSwpLkId;
		}
		
		@Override
		@RosettaAttribute("pric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pric")
		public SecuritiesTransactionPrice17Choice__1 getPric() {
			return pric;
		}
		
		@Override
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sprd")
		public SecuritiesTransactionPrice20Choice__1 getSprd() {
			return sprd;
		}
		
		@Override
		public Package4__1 build() {
			return this;
		}
		
		@Override
		public Package4__1.Package4__1Builder toBuilder() {
			Package4__1.Package4__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Package4__1.Package4__1Builder builder) {
			ofNullable(getCmplxTradId()).ifPresent(builder::setCmplxTradId);
			ofNullable(getFxSwpLkId()).ifPresent(builder::setFxSwpLkId);
			ofNullable(getPric()).ifPresent(builder::setPric);
			ofNullable(getSprd()).ifPresent(builder::setSprd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Package4__1 _that = getType().cast(o);
		
			if (!Objects.equals(cmplxTradId, _that.getCmplxTradId())) return false;
			if (!Objects.equals(fxSwpLkId, _that.getFxSwpLkId())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			if (!Objects.equals(sprd, _that.getSprd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cmplxTradId != null ? cmplxTradId.hashCode() : 0);
			_result = 31 * _result + (fxSwpLkId != null ? fxSwpLkId.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			_result = 31 * _result + (sprd != null ? sprd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Package4__1 {" +
				"cmplxTradId=" + this.cmplxTradId + ", " +
				"fxSwpLkId=" + this.fxSwpLkId + ", " +
				"pric=" + this.pric + ", " +
				"sprd=" + this.sprd +
			'}';
		}
	}

	/*********************** Builder Implementation of Package4__1  ***********************/
	class Package4__1BuilderImpl implements Package4__1.Package4__1Builder {
	
		protected String cmplxTradId;
		protected String fxSwpLkId;
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder pric;
		protected SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder sprd;
		
		@Override
		@RosettaAttribute("cmplxTradId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cmplxTradId")
		public String getCmplxTradId() {
			return cmplxTradId;
		}
		
		@Override
		@RosettaAttribute("fxSwpLkId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxSwpLkId")
		public String getFxSwpLkId() {
			return fxSwpLkId;
		}
		
		@Override
		@RosettaAttribute("pric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pric")
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getPric() {
			return pric;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreatePric() {
			SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder result;
			if (pric!=null) {
				result = pric;
			}
			else {
				result = pric = SecuritiesTransactionPrice17Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sprd")
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getSprd() {
			return sprd;
		}
		
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getOrCreateSprd() {
			SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder result;
			if (sprd!=null) {
				result = sprd;
			}
			else {
				result = sprd = SecuritiesTransactionPrice20Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cmplxTradId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cmplxTradId")
		@Override
		public Package4__1.Package4__1Builder setCmplxTradId(String _cmplxTradId) {
			this.cmplxTradId = _cmplxTradId == null ? null : _cmplxTradId;
			return this;
		}
		
		@RosettaAttribute("fxSwpLkId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxSwpLkId")
		@Override
		public Package4__1.Package4__1Builder setFxSwpLkId(String _fxSwpLkId) {
			this.fxSwpLkId = _fxSwpLkId == null ? null : _fxSwpLkId;
			return this;
		}
		
		@RosettaAttribute("pric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pric")
		@Override
		public Package4__1.Package4__1Builder setPric(SecuritiesTransactionPrice17Choice__1 _pric) {
			this.pric = _pric == null ? null : _pric.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sprd")
		@Override
		public Package4__1.Package4__1Builder setSprd(SecuritiesTransactionPrice20Choice__1 _sprd) {
			this.sprd = _sprd == null ? null : _sprd.toBuilder();
			return this;
		}
		
		@Override
		public Package4__1 build() {
			return new Package4__1.Package4__1Impl(this);
		}
		
		@Override
		public Package4__1.Package4__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Package4__1.Package4__1Builder prune() {
			if (pric!=null && !pric.prune().hasData()) pric = null;
			if (sprd!=null && !sprd.prune().hasData()) sprd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCmplxTradId()!=null) return true;
			if (getFxSwpLkId()!=null) return true;
			if (getPric()!=null && getPric().hasData()) return true;
			if (getSprd()!=null && getSprd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Package4__1.Package4__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Package4__1.Package4__1Builder o = (Package4__1.Package4__1Builder) other;
			
			merger.mergeRosetta(getPric(), o.getPric(), this::setPric);
			merger.mergeRosetta(getSprd(), o.getSprd(), this::setSprd);
			
			merger.mergeBasic(getCmplxTradId(), o.getCmplxTradId(), this::setCmplxTradId);
			merger.mergeBasic(getFxSwpLkId(), o.getFxSwpLkId(), this::setFxSwpLkId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Package4__1 _that = getType().cast(o);
		
			if (!Objects.equals(cmplxTradId, _that.getCmplxTradId())) return false;
			if (!Objects.equals(fxSwpLkId, _that.getFxSwpLkId())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			if (!Objects.equals(sprd, _that.getSprd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cmplxTradId != null ? cmplxTradId.hashCode() : 0);
			_result = 31 * _result + (fxSwpLkId != null ? fxSwpLkId.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			_result = 31 * _result + (sprd != null ? sprd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Package4__1Builder {" +
				"cmplxTradId=" + this.cmplxTradId + ", " +
				"fxSwpLkId=" + this.fxSwpLkId + ", " +
				"pric=" + this.pric + ", " +
				"sprd=" + this.sprd +
			'}';
		}
	}
}
