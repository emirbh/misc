package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.SettledEntityMatrixMeta;
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
@RosettaDataType(value="SettledEntityMatrix", builder=SettledEntityMatrix.SettledEntityMatrixBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettledEntityMatrix", model="fpml", builder=SettledEntityMatrix.SettledEntityMatrixBuilderImpl.class, version="2.1.1")
public interface SettledEntityMatrix extends RosettaModelObject {

	SettledEntityMatrixMeta metaData = new SettledEntityMatrixMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Relevant settled entity matrix source.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Relevant settled entity matrix source.
	 *
	 */
	MatrixSource getMatrixSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.
	 *
	 */
	ZonedDateTime getPublicationDate();

	/*********************** Build Methods  ***********************/
	SettledEntityMatrix build();
	
	SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder();
	
	static SettledEntityMatrix.SettledEntityMatrixBuilder builder() {
		return new SettledEntityMatrix.SettledEntityMatrixBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettledEntityMatrix> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettledEntityMatrix> getType() {
		return SettledEntityMatrix.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("matrixSource"), processor, MatrixSource.class, getMatrixSource());
		processor.processBasic(path.newSubPath("publicationDate"), ZonedDateTime.class, getPublicationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettledEntityMatrixBuilder extends SettledEntityMatrix, RosettaModelObjectBuilder {
		MatrixSource.MatrixSourceBuilder getOrCreateMatrixSource();
		@Override
		MatrixSource.MatrixSourceBuilder getMatrixSource();
		SettledEntityMatrix.SettledEntityMatrixBuilder setMatrixSource(MatrixSource matrixSource);
		SettledEntityMatrix.SettledEntityMatrixBuilder setPublicationDate(ZonedDateTime publicationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("matrixSource"), processor, MatrixSource.MatrixSourceBuilder.class, getMatrixSource());
			processor.processBasic(path.newSubPath("publicationDate"), ZonedDateTime.class, getPublicationDate(), this);
		}
		

		SettledEntityMatrix.SettledEntityMatrixBuilder prune();
	}

	/*********************** Immutable Implementation of SettledEntityMatrix  ***********************/
	class SettledEntityMatrixImpl implements SettledEntityMatrix {
		private final MatrixSource matrixSource;
		private final ZonedDateTime publicationDate;
		
		protected SettledEntityMatrixImpl(SettledEntityMatrix.SettledEntityMatrixBuilder builder) {
			this.matrixSource = ofNullable(builder.getMatrixSource()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
		}
		
		@Override
		@RosettaAttribute("matrixSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matrixSource")
		public MatrixSource getMatrixSource() {
			return matrixSource;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationDate")
		public ZonedDateTime getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		public SettledEntityMatrix build() {
			return this;
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder() {
			SettledEntityMatrix.SettledEntityMatrixBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettledEntityMatrix.SettledEntityMatrixBuilder builder) {
			ofNullable(getMatrixSource()).ifPresent(builder::setMatrixSource);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettledEntityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixSource, _that.getMatrixSource())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixSource != null ? matrixSource.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettledEntityMatrix {" +
				"matrixSource=" + this.matrixSource + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of SettledEntityMatrix  ***********************/
	class SettledEntityMatrixBuilderImpl implements SettledEntityMatrix.SettledEntityMatrixBuilder {
	
		protected MatrixSource.MatrixSourceBuilder matrixSource;
		protected ZonedDateTime publicationDate;
		
		@Override
		@RosettaAttribute("matrixSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("matrixSource")
		public MatrixSource.MatrixSourceBuilder getMatrixSource() {
			return matrixSource;
		}
		
		@Override
		public MatrixSource.MatrixSourceBuilder getOrCreateMatrixSource() {
			MatrixSource.MatrixSourceBuilder result;
			if (matrixSource!=null) {
				result = matrixSource;
			}
			else {
				result = matrixSource = MatrixSource.builder();
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
		
		@RosettaAttribute("matrixSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("matrixSource")
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder setMatrixSource(MatrixSource _matrixSource) {
			this.matrixSource = _matrixSource == null ? null : _matrixSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publicationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publicationDate")
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder setPublicationDate(ZonedDateTime _publicationDate) {
			this.publicationDate = _publicationDate == null ? null : _publicationDate;
			return this;
		}
		
		@Override
		public SettledEntityMatrix build() {
			return new SettledEntityMatrix.SettledEntityMatrixImpl(this);
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder prune() {
			if (matrixSource!=null && !matrixSource.prune().hasData()) matrixSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMatrixSource()!=null && getMatrixSource().hasData()) return true;
			if (getPublicationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettledEntityMatrix.SettledEntityMatrixBuilder o = (SettledEntityMatrix.SettledEntityMatrixBuilder) other;
			
			merger.mergeRosetta(getMatrixSource(), o.getMatrixSource(), this::setMatrixSource);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettledEntityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixSource, _that.getMatrixSource())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixSource != null ? matrixSource.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettledEntityMatrixBuilder {" +
				"matrixSource=" + this.matrixSource + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
}
