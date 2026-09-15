package iso20022.auth108.hkma.tr;

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
import iso20022.auth108.hkma.tr.meta.PostedMarginOrCollateral6__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information on the posted margin or collateral of the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="PostedMarginOrCollateral6__1", builder=PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PostedMarginOrCollateral6__1", model="iso20022", builder=PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1BuilderImpl.class, version="${project.version}")
public interface PostedMarginOrCollateral6__1 extends RosettaModelObject {

	PostedMarginOrCollateral6__1Meta metaData = new PostedMarginOrCollateral6__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Value of the initial margin posted by the reporting counterparty to the other counterparty. Where initial margin is posted on a portfolio basis, this field should include the overall value of initial margin posted for the portfolio.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnPstdPreHrcut();
	/**
	 * Value of the initial margin posted by the reporting counterparty to the other counterparty. Where initial margin is posted on a portfolio basis, this field should include the overall value of initial margin posted for the portfolio. Post-haircut values of margins depend on associated risk of changes in collateral value and therefore on the nature of the collateral posted (or collected).
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnPstdPstHrcut();
	/**
	 * Value of the variation margin posted, including cash settled, by the reporting counterparty to the other counterparty. Where variation margin is posted on a portfolio basis, this field should include the overall value of variation margin posted for the portfolio.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnPstdPreHrcut();
	/**
	 * Value of the variation margin posted, including cash settled, by the reporting counterparty to the other counterparty. Where variation margin is posted on a portfolio basis, this field should include the overall value of variation margin posted for the portfolio. Post-haircut values of margins depend on associated risk of changes in collateral value and therefore on the nature of the collateral posted (or collected).
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnPstdPstHrcut();
	/**
	 * Value of collateral posted in excess of the required collateral.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getXcssCollPstd();

	/*********************** Build Methods  ***********************/
	PostedMarginOrCollateral6__1 build();
	
	PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder toBuilder();
	
	static PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder builder() {
		return new PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PostedMarginOrCollateral6__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PostedMarginOrCollateral6__1> getType() {
		return PostedMarginOrCollateral6__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initlMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getInitlMrgnPstdPreHrcut());
		processRosetta(path.newSubPath("initlMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getInitlMrgnPstdPstHrcut());
		processRosetta(path.newSubPath("vartnMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getVartnMrgnPstdPreHrcut());
		processRosetta(path.newSubPath("vartnMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getVartnMrgnPstdPstHrcut());
		processRosetta(path.newSubPath("xcssCollPstd"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getXcssCollPstd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostedMarginOrCollateral6__1Builder extends PostedMarginOrCollateral6__1, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnPstdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnPstdPreHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnPstdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnPstdPstHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnPstdPreHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnPstdPreHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnPstdPstHrcut();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnPstdPstHrcut();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateXcssCollPstd();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getXcssCollPstd();
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setInitlMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnPstdPreHrcut);
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setInitlMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnPstdPstHrcut);
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setVartnMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnPstdPreHrcut);
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setVartnMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnPstdPstHrcut);
		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setXcssCollPstd(ActiveOrHistoricCurrencyAnd5DecimalAmount xcssCollPstd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initlMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getInitlMrgnPstdPreHrcut());
			processRosetta(path.newSubPath("initlMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getInitlMrgnPstdPstHrcut());
			processRosetta(path.newSubPath("vartnMrgnPstdPreHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getVartnMrgnPstdPreHrcut());
			processRosetta(path.newSubPath("vartnMrgnPstdPstHrcut"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getVartnMrgnPstdPstHrcut());
			processRosetta(path.newSubPath("xcssCollPstd"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getXcssCollPstd());
		}
		

		PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder prune();
	}

	/*********************** Immutable Implementation of PostedMarginOrCollateral6__1  ***********************/
	class PostedMarginOrCollateral6__1Impl implements PostedMarginOrCollateral6__1 {
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnPstdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount initlMrgnPstdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnPstdPreHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount vartnMrgnPstdPstHrcut;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount xcssCollPstd;
		
		protected PostedMarginOrCollateral6__1Impl(PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder builder) {
			this.initlMrgnPstdPreHrcut = ofNullable(builder.getInitlMrgnPstdPreHrcut()).map(f->f.build()).orElse(null);
			this.initlMrgnPstdPstHrcut = ofNullable(builder.getInitlMrgnPstdPstHrcut()).map(f->f.build()).orElse(null);
			this.vartnMrgnPstdPreHrcut = ofNullable(builder.getVartnMrgnPstdPreHrcut()).map(f->f.build()).orElse(null);
			this.vartnMrgnPstdPstHrcut = ofNullable(builder.getVartnMrgnPstdPstHrcut()).map(f->f.build()).orElse(null);
			this.xcssCollPstd = ofNullable(builder.getXcssCollPstd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnPstdPreHrcut() {
			return initlMrgnPstdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getInitlMrgnPstdPstHrcut() {
			return initlMrgnPstdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnPstdPreHrcut() {
			return vartnMrgnPstdPreHrcut;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getVartnMrgnPstdPstHrcut() {
			return vartnMrgnPstdPstHrcut;
		}
		
		@Override
		@RosettaAttribute("xcssCollPstd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xcssCollPstd")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getXcssCollPstd() {
			return xcssCollPstd;
		}
		
		@Override
		public PostedMarginOrCollateral6__1 build() {
			return this;
		}
		
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder toBuilder() {
			PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder builder) {
			ofNullable(getInitlMrgnPstdPreHrcut()).ifPresent(builder::setInitlMrgnPstdPreHrcut);
			ofNullable(getInitlMrgnPstdPstHrcut()).ifPresent(builder::setInitlMrgnPstdPstHrcut);
			ofNullable(getVartnMrgnPstdPreHrcut()).ifPresent(builder::setVartnMrgnPstdPreHrcut);
			ofNullable(getVartnMrgnPstdPstHrcut()).ifPresent(builder::setVartnMrgnPstdPstHrcut);
			ofNullable(getXcssCollPstd()).ifPresent(builder::setXcssCollPstd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedMarginOrCollateral6__1 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPstdPreHrcut, _that.getInitlMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(initlMrgnPstdPstHrcut, _that.getInitlMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPreHrcut, _that.getVartnMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPstHrcut, _that.getVartnMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(xcssCollPstd, _that.getXcssCollPstd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPstdPreHrcut != null ? initlMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (initlMrgnPstdPstHrcut != null ? initlMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPreHrcut != null ? vartnMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPstHrcut != null ? vartnMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (xcssCollPstd != null ? xcssCollPstd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedMarginOrCollateral6__1 {" +
				"initlMrgnPstdPreHrcut=" + this.initlMrgnPstdPreHrcut + ", " +
				"initlMrgnPstdPstHrcut=" + this.initlMrgnPstdPstHrcut + ", " +
				"vartnMrgnPstdPreHrcut=" + this.vartnMrgnPstdPreHrcut + ", " +
				"vartnMrgnPstdPstHrcut=" + this.vartnMrgnPstdPstHrcut + ", " +
				"xcssCollPstd=" + this.xcssCollPstd +
			'}';
		}
	}

	/*********************** Builder Implementation of PostedMarginOrCollateral6__1  ***********************/
	class PostedMarginOrCollateral6__1BuilderImpl implements PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder {
	
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder initlMrgnPstdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder initlMrgnPstdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder vartnMrgnPstdPreHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder vartnMrgnPstdPstHrcut;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder xcssCollPstd;
		
		@Override
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnPstdPreHrcut() {
			return initlMrgnPstdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnPstdPreHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (initlMrgnPstdPreHrcut!=null) {
				result = initlMrgnPstdPreHrcut;
			}
			else {
				result = initlMrgnPstdPreHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getInitlMrgnPstdPstHrcut() {
			return initlMrgnPstdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateInitlMrgnPstdPstHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (initlMrgnPstdPstHrcut!=null) {
				result = initlMrgnPstdPstHrcut;
			}
			else {
				result = initlMrgnPstdPstHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnPstdPreHrcut() {
			return vartnMrgnPstdPreHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnPstdPreHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (vartnMrgnPstdPreHrcut!=null) {
				result = vartnMrgnPstdPreHrcut;
			}
			else {
				result = vartnMrgnPstdPreHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vartnMrgnPstdPstHrcut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vartnMrgnPstdPstHrcut")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getVartnMrgnPstdPstHrcut() {
			return vartnMrgnPstdPstHrcut;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateVartnMrgnPstdPstHrcut() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (vartnMrgnPstdPstHrcut!=null) {
				result = vartnMrgnPstdPstHrcut;
			}
			else {
				result = vartnMrgnPstdPstHrcut = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("xcssCollPstd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xcssCollPstd")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getXcssCollPstd() {
			return xcssCollPstd;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateXcssCollPstd() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (xcssCollPstd!=null) {
				result = xcssCollPstd;
			}
			else {
				result = xcssCollPstd = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("initlMrgnPstdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnPstdPreHrcut")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setInitlMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _initlMrgnPstdPreHrcut) {
			this.initlMrgnPstdPreHrcut = _initlMrgnPstdPreHrcut == null ? null : _initlMrgnPstdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initlMrgnPstdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initlMrgnPstdPstHrcut")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setInitlMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _initlMrgnPstdPstHrcut) {
			this.initlMrgnPstdPstHrcut = _initlMrgnPstdPstHrcut == null ? null : _initlMrgnPstdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnPstdPreHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnPstdPreHrcut")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setVartnMrgnPstdPreHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _vartnMrgnPstdPreHrcut) {
			this.vartnMrgnPstdPreHrcut = _vartnMrgnPstdPreHrcut == null ? null : _vartnMrgnPstdPreHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vartnMrgnPstdPstHrcut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vartnMrgnPstdPstHrcut")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setVartnMrgnPstdPstHrcut(ActiveOrHistoricCurrencyAnd5DecimalAmount _vartnMrgnPstdPstHrcut) {
			this.vartnMrgnPstdPstHrcut = _vartnMrgnPstdPstHrcut == null ? null : _vartnMrgnPstdPstHrcut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("xcssCollPstd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("xcssCollPstd")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder setXcssCollPstd(ActiveOrHistoricCurrencyAnd5DecimalAmount _xcssCollPstd) {
			this.xcssCollPstd = _xcssCollPstd == null ? null : _xcssCollPstd.toBuilder();
			return this;
		}
		
		@Override
		public PostedMarginOrCollateral6__1 build() {
			return new PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Impl(this);
		}
		
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder prune() {
			if (initlMrgnPstdPreHrcut!=null && !initlMrgnPstdPreHrcut.prune().hasData()) initlMrgnPstdPreHrcut = null;
			if (initlMrgnPstdPstHrcut!=null && !initlMrgnPstdPstHrcut.prune().hasData()) initlMrgnPstdPstHrcut = null;
			if (vartnMrgnPstdPreHrcut!=null && !vartnMrgnPstdPreHrcut.prune().hasData()) vartnMrgnPstdPreHrcut = null;
			if (vartnMrgnPstdPstHrcut!=null && !vartnMrgnPstdPstHrcut.prune().hasData()) vartnMrgnPstdPstHrcut = null;
			if (xcssCollPstd!=null && !xcssCollPstd.prune().hasData()) xcssCollPstd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitlMrgnPstdPreHrcut()!=null && getInitlMrgnPstdPreHrcut().hasData()) return true;
			if (getInitlMrgnPstdPstHrcut()!=null && getInitlMrgnPstdPstHrcut().hasData()) return true;
			if (getVartnMrgnPstdPreHrcut()!=null && getVartnMrgnPstdPreHrcut().hasData()) return true;
			if (getVartnMrgnPstdPstHrcut()!=null && getVartnMrgnPstdPstHrcut().hasData()) return true;
			if (getXcssCollPstd()!=null && getXcssCollPstd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder o = (PostedMarginOrCollateral6__1.PostedMarginOrCollateral6__1Builder) other;
			
			merger.mergeRosetta(getInitlMrgnPstdPreHrcut(), o.getInitlMrgnPstdPreHrcut(), this::setInitlMrgnPstdPreHrcut);
			merger.mergeRosetta(getInitlMrgnPstdPstHrcut(), o.getInitlMrgnPstdPstHrcut(), this::setInitlMrgnPstdPstHrcut);
			merger.mergeRosetta(getVartnMrgnPstdPreHrcut(), o.getVartnMrgnPstdPreHrcut(), this::setVartnMrgnPstdPreHrcut);
			merger.mergeRosetta(getVartnMrgnPstdPstHrcut(), o.getVartnMrgnPstdPstHrcut(), this::setVartnMrgnPstdPstHrcut);
			merger.mergeRosetta(getXcssCollPstd(), o.getXcssCollPstd(), this::setXcssCollPstd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedMarginOrCollateral6__1 _that = getType().cast(o);
		
			if (!Objects.equals(initlMrgnPstdPreHrcut, _that.getInitlMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(initlMrgnPstdPstHrcut, _that.getInitlMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPreHrcut, _that.getVartnMrgnPstdPreHrcut())) return false;
			if (!Objects.equals(vartnMrgnPstdPstHrcut, _that.getVartnMrgnPstdPstHrcut())) return false;
			if (!Objects.equals(xcssCollPstd, _that.getXcssCollPstd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initlMrgnPstdPreHrcut != null ? initlMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (initlMrgnPstdPstHrcut != null ? initlMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPreHrcut != null ? vartnMrgnPstdPreHrcut.hashCode() : 0);
			_result = 31 * _result + (vartnMrgnPstdPstHrcut != null ? vartnMrgnPstdPstHrcut.hashCode() : 0);
			_result = 31 * _result + (xcssCollPstd != null ? xcssCollPstd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedMarginOrCollateral6__1Builder {" +
				"initlMrgnPstdPreHrcut=" + this.initlMrgnPstdPreHrcut + ", " +
				"initlMrgnPstdPstHrcut=" + this.initlMrgnPstdPstHrcut + ", " +
				"vartnMrgnPstdPreHrcut=" + this.vartnMrgnPstdPreHrcut + ", " +
				"vartnMrgnPstdPstHrcut=" + this.vartnMrgnPstdPstHrcut + ", " +
				"xcssCollPstd=" + this.xcssCollPstd +
			'}';
		}
	}
}
