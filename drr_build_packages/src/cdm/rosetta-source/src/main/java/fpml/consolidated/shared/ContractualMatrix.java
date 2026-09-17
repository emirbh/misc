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
import fpml.consolidated.shared.meta.ContractualMatrixMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ContractualMatrix", builder=ContractualMatrix.ContractualMatrixBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ContractualMatrix", model="fpml", builder=ContractualMatrix.ContractualMatrixBuilderImpl.class, version="2.1.1")
public interface ContractualMatrix extends RosettaModelObject {

	ContractualMatrixMeta metaData = new ContractualMatrixMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the form of applicable matrix.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the form of applicable matrix.
	 *
	 */
	MatrixType getMatrixType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the publication date of the applicable version of the matrix. When this element is omitted, the ISDA supplemental language for incorporation of the relevant matrix will generally define rules for which version of the matrix is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the publication date of the applicable version of the matrix. When this element is omitted, the ISDA supplemental language for incorporation of the relevant matrix will generally define rules for which version of the matrix is applicable.
	 *
	 */
	ZonedDateTime getPublicationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines any applicable key into the relevant matrix. For example, the Transaction Type would be the single term required for the Credit Derivatives Physical Settlement Matrix. This element should be omitted in the case of the 2000 ISDA Definitions Settlement Matrix for Early Termination and Swaptions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines any applicable key into the relevant matrix. For example, the Transaction Type would be the single term required for the Credit Derivatives Physical Settlement Matrix. This element should be omitted in the case of the 2000 ISDA Definitions Settlement Matrix for Early Termination and Swaptions.
	 *
	 */
	MatrixTerm getMatrixTerm();

	/*********************** Build Methods  ***********************/
	ContractualMatrix build();
	
	ContractualMatrix.ContractualMatrixBuilder toBuilder();
	
	static ContractualMatrix.ContractualMatrixBuilder builder() {
		return new ContractualMatrix.ContractualMatrixBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractualMatrix> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractualMatrix> getType() {
		return ContractualMatrix.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("matrixType"), processor, MatrixType.class, getMatrixType());
		processor.processBasic(path.newSubPath("publicationDate"), ZonedDateTime.class, getPublicationDate(), this);
		processRosetta(path.newSubPath("matrixTerm"), processor, MatrixTerm.class, getMatrixTerm());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractualMatrixBuilder extends ContractualMatrix, RosettaModelObjectBuilder {
		MatrixType.MatrixTypeBuilder getOrCreateMatrixType();
		@Override
		MatrixType.MatrixTypeBuilder getMatrixType();
		MatrixTerm.MatrixTermBuilder getOrCreateMatrixTerm();
		@Override
		MatrixTerm.MatrixTermBuilder getMatrixTerm();
		ContractualMatrix.ContractualMatrixBuilder setMatrixType(MatrixType matrixType);
		ContractualMatrix.ContractualMatrixBuilder setPublicationDate(ZonedDateTime publicationDate);
		ContractualMatrix.ContractualMatrixBuilder setMatrixTerm(MatrixTerm matrixTerm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("matrixType"), processor, MatrixType.MatrixTypeBuilder.class, getMatrixType());
			processor.processBasic(path.newSubPath("publicationDate"), ZonedDateTime.class, getPublicationDate(), this);
			processRosetta(path.newSubPath("matrixTerm"), processor, MatrixTerm.MatrixTermBuilder.class, getMatrixTerm());
		}
		

		ContractualMatrix.ContractualMatrixBuilder prune();
	}

	/*********************** Immutable Implementation of ContractualMatrix  ***********************/
	class ContractualMatrixImpl implements ContractualMatrix {
		private final MatrixType matrixType;
		private final ZonedDateTime publicationDate;
		private final MatrixTerm matrixTerm;
		
		protected ContractualMatrixImpl(ContractualMatrix.ContractualMatrixBuilder builder) {
			this.matrixType = ofNullable(builder.getMatrixType()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
			this.matrixTerm = ofNullable(builder.getMatrixTerm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("matrixType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matrixType")
		public MatrixType getMatrixType() {
			return matrixType;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationDate")
		public ZonedDateTime getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		@RosettaAttribute("matrixTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matrixTerm")
		public MatrixTerm getMatrixTerm() {
			return matrixTerm;
		}
		
		@Override
		public ContractualMatrix build() {
			return this;
		}
		
		@Override
		public ContractualMatrix.ContractualMatrixBuilder toBuilder() {
			ContractualMatrix.ContractualMatrixBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualMatrix.ContractualMatrixBuilder builder) {
			ofNullable(getMatrixType()).ifPresent(builder::setMatrixType);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
			ofNullable(getMatrixTerm()).ifPresent(builder::setMatrixTerm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixType, _that.getMatrixType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			if (!Objects.equals(matrixTerm, _that.getMatrixTerm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixType != null ? matrixType.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			_result = 31 * _result + (matrixTerm != null ? matrixTerm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualMatrix {" +
				"matrixType=" + this.matrixType + ", " +
				"publicationDate=" + this.publicationDate + ", " +
				"matrixTerm=" + this.matrixTerm +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractualMatrix  ***********************/
	class ContractualMatrixBuilderImpl implements ContractualMatrix.ContractualMatrixBuilder {
	
		protected MatrixType.MatrixTypeBuilder matrixType;
		protected ZonedDateTime publicationDate;
		protected MatrixTerm.MatrixTermBuilder matrixTerm;
		
		@Override
		@RosettaAttribute("matrixType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matrixType")
		public MatrixType.MatrixTypeBuilder getMatrixType() {
			return matrixType;
		}
		
		@Override
		public MatrixType.MatrixTypeBuilder getOrCreateMatrixType() {
			MatrixType.MatrixTypeBuilder result;
			if (matrixType!=null) {
				result = matrixType;
			}
			else {
				result = matrixType = MatrixType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationDate")
		public ZonedDateTime getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		@RosettaAttribute("matrixTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matrixTerm")
		public MatrixTerm.MatrixTermBuilder getMatrixTerm() {
			return matrixTerm;
		}
		
		@Override
		public MatrixTerm.MatrixTermBuilder getOrCreateMatrixTerm() {
			MatrixTerm.MatrixTermBuilder result;
			if (matrixTerm!=null) {
				result = matrixTerm;
			}
			else {
				result = matrixTerm = MatrixTerm.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("matrixType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("matrixType")
		@Override
		public ContractualMatrix.ContractualMatrixBuilder setMatrixType(MatrixType _matrixType) {
			this.matrixType = _matrixType == null ? null : _matrixType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publicationDate")
		@Override
		public ContractualMatrix.ContractualMatrixBuilder setPublicationDate(ZonedDateTime _publicationDate) {
			this.publicationDate = _publicationDate == null ? null : _publicationDate;
			return this;
		}
		
		@RosettaAttribute("matrixTerm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("matrixTerm")
		@Override
		public ContractualMatrix.ContractualMatrixBuilder setMatrixTerm(MatrixTerm _matrixTerm) {
			this.matrixTerm = _matrixTerm == null ? null : _matrixTerm.toBuilder();
			return this;
		}
		
		@Override
		public ContractualMatrix build() {
			return new ContractualMatrix.ContractualMatrixImpl(this);
		}
		
		@Override
		public ContractualMatrix.ContractualMatrixBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualMatrix.ContractualMatrixBuilder prune() {
			if (matrixType!=null && !matrixType.prune().hasData()) matrixType = null;
			if (matrixTerm!=null && !matrixTerm.prune().hasData()) matrixTerm = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMatrixType()!=null && getMatrixType().hasData()) return true;
			if (getPublicationDate()!=null) return true;
			if (getMatrixTerm()!=null && getMatrixTerm().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualMatrix.ContractualMatrixBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualMatrix.ContractualMatrixBuilder o = (ContractualMatrix.ContractualMatrixBuilder) other;
			
			merger.mergeRosetta(getMatrixType(), o.getMatrixType(), this::setMatrixType);
			merger.mergeRosetta(getMatrixTerm(), o.getMatrixTerm(), this::setMatrixTerm);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixType, _that.getMatrixType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			if (!Objects.equals(matrixTerm, _that.getMatrixTerm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixType != null ? matrixType.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			_result = 31 * _result + (matrixTerm != null ? matrixTerm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualMatrixBuilder {" +
				"matrixType=" + this.matrixType + ", " +
				"publicationDate=" + this.publicationDate + ", " +
				"matrixTerm=" + this.matrixTerm +
			'}';
		}
	}
}
