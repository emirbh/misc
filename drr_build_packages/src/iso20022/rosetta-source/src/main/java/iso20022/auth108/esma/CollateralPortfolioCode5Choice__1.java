package iso20022.auth108.esma;

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
import iso20022.auth108.esma.meta.CollateralPortfolioCode5Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the unique codes identifying the portfolio.
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralPortfolioCode5Choice__1", builder=CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CollateralPortfolioCode5Choice__1", model="iso20022", builder=CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1BuilderImpl.class, version="${project.version}")
public interface CollateralPortfolioCode5Choice__1 extends RosettaModelObject {

	CollateralPortfolioCode5Choice__1Meta metaData = new CollateralPortfolioCode5Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.  Usage: NoPortfolio is reported if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement or if no collateral is posted or received.
	 */
	PortfolioCode3Choice getPrtfl();

	/*********************** Build Methods  ***********************/
	CollateralPortfolioCode5Choice__1 build();
	
	CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder toBuilder();
	
	static CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder builder() {
		return new CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPortfolioCode5Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralPortfolioCode5Choice__1> getType() {
		return CollateralPortfolioCode5Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("prtfl"), processor, PortfolioCode3Choice.class, getPrtfl());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPortfolioCode5Choice__1Builder extends CollateralPortfolioCode5Choice__1, RosettaModelObjectBuilder {
		PortfolioCode3Choice.PortfolioCode3ChoiceBuilder getOrCreatePrtfl();
		@Override
		PortfolioCode3Choice.PortfolioCode3ChoiceBuilder getPrtfl();
		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder setPrtfl(PortfolioCode3Choice prtfl);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("prtfl"), processor, PortfolioCode3Choice.PortfolioCode3ChoiceBuilder.class, getPrtfl());
		}
		

		CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of CollateralPortfolioCode5Choice__1  ***********************/
	class CollateralPortfolioCode5Choice__1Impl implements CollateralPortfolioCode5Choice__1 {
		private final PortfolioCode3Choice prtfl;
		
		protected CollateralPortfolioCode5Choice__1Impl(CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder builder) {
			this.prtfl = ofNullable(builder.getPrtfl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("prtfl")
		public PortfolioCode3Choice getPrtfl() {
			return prtfl;
		}
		
		@Override
		public CollateralPortfolioCode5Choice__1 build() {
			return this;
		}
		
		@Override
		public CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder toBuilder() {
			CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder builder) {
			ofNullable(getPrtfl()).ifPresent(builder::setPrtfl);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioCode5Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(prtfl, _that.getPrtfl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtfl != null ? prtfl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioCode5Choice__1 {" +
				"prtfl=" + this.prtfl +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralPortfolioCode5Choice__1  ***********************/
	class CollateralPortfolioCode5Choice__1BuilderImpl implements CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder {
	
		protected PortfolioCode3Choice.PortfolioCode3ChoiceBuilder prtfl;
		
		@Override
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("prtfl")
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder getPrtfl() {
			return prtfl;
		}
		
		@Override
		public PortfolioCode3Choice.PortfolioCode3ChoiceBuilder getOrCreatePrtfl() {
			PortfolioCode3Choice.PortfolioCode3ChoiceBuilder result;
			if (prtfl!=null) {
				result = prtfl;
			}
			else {
				result = prtfl = PortfolioCode3Choice.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("prtfl")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("prtfl")
		@Override
		public CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder setPrtfl(PortfolioCode3Choice _prtfl) {
			this.prtfl = _prtfl == null ? null : _prtfl.toBuilder();
			return this;
		}
		
		@Override
		public CollateralPortfolioCode5Choice__1 build() {
			return new CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Impl(this);
		}
		
		@Override
		public CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder prune() {
			if (prtfl!=null && !prtfl.prune().hasData()) prtfl = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrtfl()!=null && getPrtfl().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder o = (CollateralPortfolioCode5Choice__1.CollateralPortfolioCode5Choice__1Builder) other;
			
			merger.mergeRosetta(getPrtfl(), o.getPrtfl(), this::setPrtfl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioCode5Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(prtfl, _that.getPrtfl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtfl != null ? prtfl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioCode5Choice__1Builder {" +
				"prtfl=" + this.prtfl +
			'}';
		}
	}
}
