package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.PortfolioIdentification3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies the portfolio if the collateral is reported on a portfolio basis.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioIdentification3", builder=PortfolioIdentification3.PortfolioIdentification3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PortfolioIdentification3", model="iso20022", builder=PortfolioIdentification3.PortfolioIdentification3BuilderImpl.class, version="${project.version}")
public interface PortfolioIdentification3 extends RosettaModelObject {

	PortfolioIdentification3Meta metaData = new PortfolioIdentification3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique code determined by the reporting counterparty to identify the portfolio if collateral is reported on a portfolio basis.
	 */
	String getCd();
	/**
	 * Indicates whether the collateral portfolio includes transactions exempt from reporting.    Usage: If the element is not present, the PortfolioTransactionExemption is False.
	 */
	Boolean getPrtflTxXmptn();

	/*********************** Build Methods  ***********************/
	PortfolioIdentification3 build();
	
	PortfolioIdentification3.PortfolioIdentification3Builder toBuilder();
	
	static PortfolioIdentification3.PortfolioIdentification3Builder builder() {
		return new PortfolioIdentification3.PortfolioIdentification3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioIdentification3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PortfolioIdentification3> getType() {
		return PortfolioIdentification3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
		processor.processBasic(path.newSubPath("prtflTxXmptn"), Boolean.class, getPrtflTxXmptn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioIdentification3Builder extends PortfolioIdentification3, RosettaModelObjectBuilder {
		PortfolioIdentification3.PortfolioIdentification3Builder setCd(String cd);
		PortfolioIdentification3.PortfolioIdentification3Builder setPrtflTxXmptn(Boolean prtflTxXmptn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
			processor.processBasic(path.newSubPath("prtflTxXmptn"), Boolean.class, getPrtflTxXmptn(), this);
		}
		

		PortfolioIdentification3.PortfolioIdentification3Builder prune();
	}

	/*********************** Immutable Implementation of PortfolioIdentification3  ***********************/
	class PortfolioIdentification3Impl implements PortfolioIdentification3 {
		private final String cd;
		private final Boolean prtflTxXmptn;
		
		protected PortfolioIdentification3Impl(PortfolioIdentification3.PortfolioIdentification3Builder builder) {
			this.cd = builder.getCd();
			this.prtflTxXmptn = builder.getPrtflTxXmptn();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("prtflTxXmptn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtflTxXmptn")
		public Boolean getPrtflTxXmptn() {
			return prtflTxXmptn;
		}
		
		@Override
		public PortfolioIdentification3 build() {
			return this;
		}
		
		@Override
		public PortfolioIdentification3.PortfolioIdentification3Builder toBuilder() {
			PortfolioIdentification3.PortfolioIdentification3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioIdentification3.PortfolioIdentification3Builder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
			ofNullable(getPrtflTxXmptn()).ifPresent(builder::setPrtflTxXmptn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioIdentification3 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(prtflTxXmptn, _that.getPrtflTxXmptn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			_result = 31 * _result + (prtflTxXmptn != null ? prtflTxXmptn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioIdentification3 {" +
				"cd=" + this.cd + ", " +
				"prtflTxXmptn=" + this.prtflTxXmptn +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioIdentification3  ***********************/
	class PortfolioIdentification3BuilderImpl implements PortfolioIdentification3.PortfolioIdentification3Builder {
	
		protected String cd;
		protected Boolean prtflTxXmptn;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("prtflTxXmptn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtflTxXmptn")
		public Boolean getPrtflTxXmptn() {
			return prtflTxXmptn;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cd")
		@Override
		public PortfolioIdentification3.PortfolioIdentification3Builder setCd(String _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@RosettaAttribute("prtflTxXmptn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtflTxXmptn")
		@Override
		public PortfolioIdentification3.PortfolioIdentification3Builder setPrtflTxXmptn(Boolean _prtflTxXmptn) {
			this.prtflTxXmptn = _prtflTxXmptn == null ? null : _prtflTxXmptn;
			return this;
		}
		
		@Override
		public PortfolioIdentification3 build() {
			return new PortfolioIdentification3.PortfolioIdentification3Impl(this);
		}
		
		@Override
		public PortfolioIdentification3.PortfolioIdentification3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioIdentification3.PortfolioIdentification3Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			if (getPrtflTxXmptn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioIdentification3.PortfolioIdentification3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioIdentification3.PortfolioIdentification3Builder o = (PortfolioIdentification3.PortfolioIdentification3Builder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			merger.mergeBasic(getPrtflTxXmptn(), o.getPrtflTxXmptn(), this::setPrtflTxXmptn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioIdentification3 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(prtflTxXmptn, _that.getPrtflTxXmptn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			_result = 31 * _result + (prtflTxXmptn != null ? prtflTxXmptn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioIdentification3Builder {" +
				"cd=" + this.cd + ", " +
				"prtflTxXmptn=" + this.prtflTxXmptn +
			'}';
		}
	}
}
